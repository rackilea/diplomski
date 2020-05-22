import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * A square panel for rendering. NOTE: To work correctly, this must be the only
 * component in a parent with a layout that allows the child to decide the size.
 */
class SquarePanel extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        System.out.println("Preferred Size: " + d);
        int w = (int) d.getWidth();
        int h = (int) d.getHeight();
        // Set s to the larger of the mimimum component width or height
        int s = (w > h ? w : h);
        Container c = getParent();
        if (c != null ){
            Dimension sz = c.getSize();
            if ( d.getWidth()<sz.getWidth() ) {
                // Increase w to the size available in the parent container
                w = (int)sz.getWidth();
                System.out.println("WxH: " + w + "x" + h);
                // recalculate s
                s = (w < h ? w : h);
            }
            if ( d.getHeight()<sz.getHeight()) {
                // Increase h to the size available in the parent container
                h = (int)sz.getHeight();
                System.out.println("WxH: " + w + "x" + h);
                // recalculate s
                s = (w < h ? w : h);
            }
        }
        // Use s as the basis of a square of side length s.
        System.out.println("Square Preferred Size: " + new Dimension(s, s));
        return new Dimension(s, s);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getSize() {
        return getPreferredSize();
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                // A single component added to a GBL with no constraint
                // will be centered.
                JPanel gui = new JPanel(new GridBagLayout());
                gui.setBackground(Color.BLUE);

                SquarePanel p = new SquarePanel();
                p.setBorder(new EmptyBorder(5,15,5,15));
                p.setLayout(new GridLayout(3,0,2,2));
                for (int ii=1; ii<13; ii++) {
                    p.add(new JButton("" + ii));
                }
                p.setBackground(Color.red);
                gui.add(p);

                JFrame f = new JFrame("Demo");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
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