import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

public class HelloComponent extends JComponent {

    private final int COMPONENT_WIDTH = 100;
    private final int COMPONENT_HEIGHT = 30;

    public HelloComponent() {
        setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello World", 0, g.getFontMetrics().getHeight());
    }
}