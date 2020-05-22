configurations {
    console
}

dependencies {
    // ... compile dependencies, runtime dependencies, etc.
    console 'commons-cli:commons-cli:1.2'
    console('jline:jline:2.11') {
        exclude(group: 'junit', module: 'junit')
    }
    console 'org.codehaus.groovy:groovy-groovysh:2.2.+'
}

class StreamCopier implements Runnable {
    def istream
    def ostream
    StreamCopier(istream, ostream) {
        this.istream = istream
        this.ostream = ostream
    }
    void run() {
        int n
        def buffer = new byte[4096]
        while ((n = istream.read(buffer)) != -1) {
            ostream.write(buffer, 0, n)
            ostream.flush()
        }
    }
}

class InputCopier implements Runnable {
    def istream
    def ostream
    def stdout
    InputCopier(istream, ostream, stdout) {
        this.istream = istream
        this.ostream = ostream
        this.stdout = stdout
    }
    void run() {
        try {
            int n
            def buffer = java.nio.ByteBuffer.allocate(4096)
            while ((n = istream.read(buffer)) != -1) {
                ostream.write(buffer.array(), 0, n)
                ostream.flush()
                buffer.clear()
                if (127 == buffer.get(0)) {
                    stdout.print("\b \b")
                    stdout.flush()
                }
            }
        }
        catch (final java.nio.channels.AsynchronousCloseException exception) {
            // Ctrl+D pressed
        }
        finally {
            ostream.close()
        }
    }
}

def getChannel(istream) {
    def f = java.io.FilterInputStream.class.getDeclaredField("in")
    f.setAccessible(true)
    while (istream instanceof java.io.FilterInputStream) {
        istream = f.get(istream)
    }
    istream.getChannel()
}

task(console, dependsOn: 'classes') << {
    def classpath = sourceSets.main.runtimeClasspath + configurations.console

    def command = [
        'java',
        '-cp', classpath.collect().join(System.getProperty('path.separator')),
        'org.codehaus.groovy.tools.shell.Main'
    ]

    def proc = new ProcessBuilder(command).start()

    def stdout = new Thread(new StreamCopier(proc.getInputStream(), System.out))
    stdout.start()

    def stderr = new Thread(new StreamCopier(proc.getErrorStream(), System.err))
    stderr.start()

    def stdin  = new Thread(new InputCopier(
        getChannel(System.in),
        proc.getOutputStream(),
        System.out))
    stdin.start()

    proc.waitFor()
    System.in.close()
    stdout.join()
    stderr.join()
    stdin.join()

    if (0 != proc.exitValue()) {
        throw new RuntimeException("console exited with status: ${proc.exitValue()}")
    }
}