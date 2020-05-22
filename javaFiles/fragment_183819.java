public class MyPanel extends JPanel {
    private BufferedImage buffer;
    private Graphics2D canvas;

    @Override
    public void paintComponent(Graphics g) {
        if(buffer == null) {
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            canvas = buffer.createGraphics();
        }
        canvas.fillOval(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(buffer, 0, 0, this);
    }
}