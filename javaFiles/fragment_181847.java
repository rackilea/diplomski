import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SizedGUI {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new BorderLayout());
                gui.setBorder(new EmptyBorder(2,3,2,3));

                gui.add(new FixedSizeComponent());

                gui.setBackground(Color.RED);

                JFrame f = new JFrame("Demo");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // tweak to ensure the GUI never gets too small
                f.setMinimumSize(f.getSize());
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}

class FixedSizeComponent extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.BLACK);
        g.drawString(w + "x" + h, w/2, h/2);
    }
}