import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleDraw extends JPanel {
    private static final int PREF_W = 450;
    private static final int PREF_H = PREF_W;
    private static final Dimension RECT_DIM = new Dimension(10, 10);
    private Rectangle rect = null;

    public SimpleDraw() {
        addMouseMotionListener(new MyMouse());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (rect != null) {
            g2.draw(rect);
        }
    }

    // so this JPanel's is sized correctly 
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouse extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
            // simply change the Rectangle
            rect = new Rectangle(e.getPoint(), RECT_DIM);
            repaint();  // and have the JVM re-paint this JPanel
        }
    }

    private static void createAndShowGui() {
        SimpleDraw mainPanel = new SimpleDraw();

        JFrame frame = new JFrame("SimpleDraw");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // initialize our GUI on the Swing event thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}