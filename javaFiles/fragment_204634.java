ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\system32\\calc.exe");
pb.inheritIO(); // <-- passes IO from forked process.
try {
    Process p = pb.start(); // <-- forkAndExec on Unix
    p.waitFor(); // <-- waits for the forked process to complete.
} catch (Exception e) {
    e.printStackTrace();
}