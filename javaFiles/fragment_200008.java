import java.awt.*;
import javax.swing.*;

/**
 * Adapted from https://stackoverflow.com/a/1428298/1694043.
 */
public class GuiTest {
    public static void main(String[] arguments) {
        new GuiTest();
    }

    public GuiTest() {
        JFrame frame = new JFrame("Heavyweight versus lightweight");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addPanelsToFrame(frame);

        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    private void addPanelsToFrame(JFrame frame) {
        CustomCanvas customCanvas = new CustomCanvas(300, 400, Color.YELLOW);
        Panel awtPanel1 = new Panel(new BorderLayout());
        awtPanel1.setSize(300, 400);
        awtPanel1.add(customCanvas, BorderLayout.CENTER);
        frame.getLayeredPane().add(awtPanel1, JLayeredPane.DEFAULT_LAYER);

        CustomPanel customPanel = new CustomPanel(100, 100, Color.RED);
        Panel awtPanel2 = new Panel(new BorderLayout());
        awtPanel2.setSize(100, 100);
        awtPanel2.add(customPanel, BorderLayout.CENTER);
        frame.getLayeredPane().add(awtPanel2, JLayeredPane.PALETTE_LAYER);
    }


    private class CustomCanvas extends Canvas {
        private Color backgroundColor;

        public CustomCanvas(int width, int height, Color backgroundColor) {
            setSize(width, height);
            this.backgroundColor = backgroundColor;
        }

        @Override
        public void paint(Graphics g) {
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }


    private class CustomPanel extends JPanel {
        public CustomPanel(int width, int height, Color backgroundColor) {
            setSize(width, height);
            setBackground(backgroundColor);
        }
    }
}