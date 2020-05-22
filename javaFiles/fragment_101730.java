public class MainPanel extends JPanel {
    private Image image;

    MainPanel() {
        setTransferHandler(new ImageTransferHandler(this));
    }

    void addFiles(File[] files) {
        for (File file : files) {
            try {
                image = ImageIO.read(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (image != null) {
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        int width = getWidth();
        int height = getHeight();
        drawImage((Graphics2D) g, width, height);
    }

    private void drawImage(Graphics2D g2, int width, int height) {
        if (image != null) {
            g2.drawImage(image, 0, 0, width, height, null);
        } else {
            g2.drawRect(10, 10, width - 20, height - 20);
        }
    }
}