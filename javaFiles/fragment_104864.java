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

task(console, dependsOn: 'classes') << {
    def classpath = sourceSets.main.runtimeClasspath + configurations.console

    def command = [
        'java',
        '-cp', classpath.collect().join(System.getProperty('path.separator')),
        'org.codehaus.groovy.tools.shell.Main',
        '--color'
    ]

    def proc = new ProcessBuilder(command)
        .redirectOutput(ProcessBuilder.Redirect.INHERIT)
        .redirectInput(ProcessBuilder.Redirect.INHERIT)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()

    proc.waitFor()

    if (0 != proc.exitValue()) {
        throw new RuntimeException("console exited with status: ${proc.exitValue()}")
    }
}