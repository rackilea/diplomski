Process p = Runtime.getRuntime().exec("ffmpeg.exe...");
new Thread(new StreamDump(p.getErrorStream()), "error stream").start();
new Thread(new StreamDump(p.getInputStream()), "output stream").start();
try {
    p.waitFor();
} catch (InterruptedException e) {
    e.printStackTrace();
}
System.out.println("Exit value: " + p.exitValue());