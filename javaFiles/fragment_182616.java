import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;

public class SSCCE {

    private JFrame componentsFrame = new JFrame();
    private JFrame remoteFrame = new JFrame();
    private int lastMouseX, lastMouseY;
    final JPanel panel = new JPanel();

    public SSCCE() {
        panel.add(new JButton("A Button"));
        panel.add(new JComboBox(new String[]{"A", "Combo", "Box"}));
        panel.add(new JSlider());
        panel.add(new JList(new String[]{"A", "List"}));
        panel.add(new JCheckBox("Check Box"));
        componentsFrame.add(panel);
        componentsFrame.setGlassPane(new JPanel() {

            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.red);
                g.drawLine(lastMouseX - 8, lastMouseY, lastMouseX + 8, lastMouseY);
                g.drawLine(lastMouseX, lastMouseY - 8, lastMouseX, lastMouseY + 8);
            }

            @Override
            public boolean isOpaque() {
                return false;
            }

            @Override
            public boolean isVisible() {
                return true;
            }
        });
        componentsFrame.setEnabled(false);
        componentsFrame.pack();
        componentsFrame.setVisible(true);
//        
        MouseAdapter mouseImpl = new MouseAdapter() {

            private Component lastPressed;

            @Override
            public void mousePressed(MouseEvent e) {
                redirectMouseEvent(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                redirectMouseEvent(e);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                redirectMouseEvent(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                redirectMouseEvent(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                redirectMouseEvent(e);
            }

            private void redirectMouseEvent(MouseEvent e) {
                Component redirectTo = SwingUtilities.getDeepestComponentAt(panel, e.getX(), e.getY());
                if (e.getID() == MouseEvent.MOUSE_PRESSED) {
                    lastPressed = redirectTo;
                } else if (e.getID() == MouseEvent.MOUSE_DRAGGED || e.getID() == MouseEvent.MOUSE_RELEASED) {
                    redirectTo = lastPressed;
                }
                if (redirectTo != null) {
                    lastMouseX = e.getX();
                    lastMouseY = e.getY();
                    panel.repaint(); //this line is just to update the glass pane
                    e = SwingUtilities.convertMouseEvent(panel, e, redirectTo);
                    java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(e);
                }
            }
        };
        remoteFrame.getContentPane().addMouseListener(mouseImpl);
        remoteFrame.getContentPane().addMouseMotionListener(mouseImpl);
        remoteFrame.setSize(componentsFrame.getSize());
        remoteFrame.setLocation(0, componentsFrame.getY() + componentsFrame.getHeight());
        remoteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        remoteFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                SSCCE sSCCE = new SSCCE();
            }
        });
    }
}