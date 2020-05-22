class HelloDrawable implements Drawable {
    @Override
    public void draw(Graphics g) {
        g.drawString("Hello", 100, 100);
    }
}
class WorldDrawable implements Drawable {
    @Override
    public void draw(Graphics g) {
        g.drawString("World", 150, 100);
    }
}

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawingPanel panel = new DrawingPanel();
        panel.addToDrawList(new HelloDrawable());
        panel.addToDrawList(new WorldDrawable());

        // panel.addToDrawMap("Hello", new HelloDrawable());
    }
}