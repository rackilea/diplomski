public class ImageRotation {
    public static void main(String[] args) throws IOException {

        BufferedImage img = ImageIO.read(
                ImageRotation.class
                        .getResourceAsStream("Capture.PNG"));

        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(
                new JLabel("Original", new ImageIcon(img), JLabel.CENTER),
                BorderLayout.WEST);

        pane.add(
                new JLabel("Rotated", new ImageIcon(rotateClockwise(img)), JLabel.CENTER),
                BorderLayout.EAST);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(pane);
        frame.setVisible(true);
        frame.pack();
    }

    static BufferedImage rotateClockwise(BufferedImage img) {
        int[] origPix = getIntBuff(img);

        int newWidth = img.getHeight();
        int newHeight = img.getWidth();
        int[] buff = new int[newWidth * newHeight];

        // formula for determining pixel mapping
        // (sizeOf(old y) - 1) - old y -> new x
        // old x -> new y

        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++) {

                int pix = origPix[x + (y * img.getWidth())];
                int newX = img.getHeight() - 1 - y, newY = x;

                buff[newX + (newWidth * newY)] = pix;
            }
        // we have now rotated the array clockwise, time to place the buffer in an image


        int type = BufferedImage.TYPE_INT_ARGB;
        BufferedImage ret = new BufferedImage(newWidth, newHeight, type);
        WritableRaster wr = ret.getRaster();
        wr.setDataElements(0, 0, newWidth, newHeight, buff);
        return ret;
    }

    // variation of convertTo2DWithoutUsingGetRGB http://stackoverflow.com/a/9470843/4683264
    private static int[] getIntBuff(BufferedImage image) {

        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[] result = new int[height * width];

        final int pixelLength = hasAlphaChannel ? 4 : 3;
        for (int pixel = 0, resInd = 0; pixel < pixels.length; pixel += pixelLength) {
            int argb = 0;
            if (hasAlphaChannel)
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
            else
                argb += -16777216; // 255 alpha

            argb += ((int) pixels[pixel + 1] & 0xff); // blue
            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
            result[resInd++] = argb;
        }

        return result;
    }

}