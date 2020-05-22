ProcessBuilder pb = new ProcessBuilder(
                "C:\\Program Files\\ImageMagick-6.9.1-Q16\\convert.exe",
                "C:\\Path\to\Large.png",
                "-resize", "1027x768",
                "C:\\Path\to\small.png");

try {
    pb.inheritIO();
    pb.redirectErrorStream();
    pb.directory(new File("C:\\Program Files\\ImageMagick-6.9.1-Q16"));
    Process p = pb.start();
    try (InputStream is = p.getInputStream()) {
        int in = -1;
        while ((in = is.read()) != -1) {
            System.out.print((char)in);
        }
    }
    System.out.println("Exited with " + p.waitFor());
} catch (IOException | InterruptedException ex) {
    ex.printStackTrace();
}