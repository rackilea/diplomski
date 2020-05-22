public class GameScreen extends JPanel {

    private ImageBuffer buffer;

    public GameScreen(int width, int height) {
        buffer = new ImageBuffer(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getPaintBuffer().getBuffer(), 0, 0, getWidth(), getHeight(), this);
    }

    public ImageBuffer getPaintBuffer() {
        return buffer;
    }

}