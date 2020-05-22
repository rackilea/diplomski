public static void main(String[] args) {
    // Original
    final BufferedImage bgr = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);

    // Paint something
    Graphics2D graphics = bgr.createGraphics();
    try {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, bgr.getWidth(), bgr.getHeight());
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, bgr.getWidth(), bgr.getHeight() / 3);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, 0, bgr.getWidth() / 3, bgr.getHeight());
    }
    finally {
        graphics.dispose();
    }

    // Clone, and swap BGR -> RGB
    ColorModel colorModel = bgr.getColorModel();
    WritableRaster swapped = bgr.getRaster().createWritableChild(0, 0, bgr.getWidth(), bgr.getHeight(), 0, 0, 
                                                                 new int[]{2, 1, 0}); // default order is 0, 1, 2
    final BufferedImage rgb = new BufferedImage(colorModel, swapped, colorModel.isAlphaPremultiplied(), null);

    System.err.println("bgr: " + bgr); // TYPE_3BYTE_BGR (5)
    System.err.println("rgb: " + rgb); // TYPE_CUSTOM (0)

    // Display it all
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            frame.add(new JLabel(new ImageIcon(bgr)), BorderLayout.WEST);
            frame.add(new JLabel(new ImageIcon(rgb)));

            frame.pack();
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        }
    });
}