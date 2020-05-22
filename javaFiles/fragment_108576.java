ProcessBuilder pb = new ProcessBuilder(
                "java", 
                "-Djava.library.path=/home/johnmichaelreed/Desktop/Dropbox/Libjitsi_linux_64/lib/native/linux-64", 
                "-cp", 
                "/home/johnmichaelreed/NetBeansProjects/SendReceive/dist/SendReceive.jar:/home/j‌​ohnmichaelreed/Desktop/Dropbox/Libjitsi_linux_64", 
                "Main", 
                "\"send\"");

pb.redirectErrorStream(true);
try {
    Process p = pb.start();
    try (InputStream is = p.getInputStream()) {
        int in = -1;
        while ((in = is.read()) != -1) {
            System.out.print((char)in);
        }
    }
    int exitCode = p.exitValue();

    System.out.println("Process exited with " + exitCode);
} catch (IOException ex) {
    ex.printStackTrace();
}