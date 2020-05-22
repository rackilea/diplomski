public static class GameScreen extends JPanel {

    private ImageBuffer buffer;
    private Dimension size;

    public GameScreen(int width, int height) {
        buffer = new ImageBuffer(width, height);
        this.size = new Dimension(width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }