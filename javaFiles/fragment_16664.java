public class MyButton extends JButton {
    private Painter painter;

    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       painter.paint(g);
    }
}

public interface Painter {
    public void paint(Graphics g);
}