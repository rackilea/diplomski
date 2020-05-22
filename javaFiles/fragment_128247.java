Process proc = Runtime.getRuntime().exec(ANonJava.exe@);
InputStream in = proc.getInputStream();
byte buff[] = new byte[1024];
int cbRead;

try {
    while ((cbRead = in.read(buff)) != -1) {
        // Use the output of the process...
    }
} catch (IOException e) {
    // Insert code to handle exceptions that occur
    // when reading the process output
}

// No more output was available from the process, so...

// Ensure that the process completes
try {
    proc.waitFor();
} catch (InterruptedException) {
    // Handle exception that could occur when waiting
    // for a spawned process to terminate
}

// Then examine the process exit code
if (proc.exitValue() == 1) {
    // Use the exit value...
}