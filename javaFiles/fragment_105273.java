public class StackOverflow27071351 {
    private static class ImagePanel extends JPanel {
        private BufferedImage image;
        public ImagePanel(int width, int height, BufferedImage image) {
            this.image = image;
            image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_ARGB);
            repaint();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    image.setRGB(i, j, new Color(255, 0, 0, 127).getRGB());
                }
            }
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        int width = 640;
        int height = 480;
        frame.setSize(width, height);
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(new ImagePanel(width, height, image));
        frame.setVisible(true);
    }
}