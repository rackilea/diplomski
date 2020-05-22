public static final void makeScreenshot(JFrame argFrame) {
    try {
        // Create temp file.
        File temp = File.createTempFile("screenshot", ".png");

        // Use the ImageIO API to write the bufferedImage to a temporary file
        ImageIO.write(getFrameImage(argFrame), "png", temp);

        // Delete temp file when program exits.
        temp.deleteOnExit();
    } catch (IOException ioe) {
    } // catch
}