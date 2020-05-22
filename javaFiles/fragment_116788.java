public class BufferedImageWrapper {
    private BufferedImage bufferredImage;

    public BufferedImageWrapper(File file) {
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // your methods here
}