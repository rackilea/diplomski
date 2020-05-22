import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;

public class JTooltipFlickerTest extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JPanel panel;

    static public void main (final String[] args) {
        new JTooltipFlickerTest ();
    }


    public JTooltipFlickerTest () {
        super ();
        panel = new JPanel ();          

        setTitle (this.getClass().toString());
        setSize (1024, 768);

        this.getContentPane().setLayout (new BorderLayout());

        SwingUtilities.invokeLater (
                new Runnable () {

                    @Override
                    public void run() {

                        final MouseAdapter ma = new MouseAdapter () {

                            public void mouseMoved (final MouseEvent e) { 
                                panel.setToolTipText ("x: "+e.getX()+", y: "+e.getY());
                            }
                        };  
                        panel.addMouseMotionListener(ma);

                        panel.setDoubleBuffered(true);
                        panel.createToolTip().setDoubleBuffered(true);

                        JTooltipFlickerTest.this.getContentPane().add (panel, "Center");                
                        JTooltipFlickerTest.this.setVisible (true);
                    }
                }
        );

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        installRepaintManager();

    }

    private void installRepaintManager() {
        ReflectionRepaintManager manager = new ReflectionRepaintManager();
        RepaintManager.setCurrentManager(manager);
    }

    private class ReflectionRepaintManager extends RepaintManager {
        public void addDirtyRegion(JComponent c, int x, int y, int w, int h) {

            int lastDeltaX = c.getX();
            int lastDeltaY = c.getY();

            Container parent = c.getParent();
            while (parent instanceof JComponent) {
                if (!parent.isVisible()) {
                    return;
                }

                if (parent instanceof JTooltipFlickerTest) {
                    x += lastDeltaX;
                    y += lastDeltaY;

                    int gap = getContentPane().getHeight() - h - y;
                    h += 2 * gap + h;

                    lastDeltaX = lastDeltaY = 0;

                    c = (JComponent) parent;
                }

                lastDeltaX += parent.getX();
                lastDeltaY += parent.getY();

                parent = parent.getParent();
            }

            super.addDirtyRegion(c, x, y, w, h);
        }
    }
}