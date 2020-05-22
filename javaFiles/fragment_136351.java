import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class IsRectVisible {

    private static void createAndShowUI() {
        JFrame frame = new JFrame("IsRectVisible");
        frame.getContentPane().add(new IsRectVisibleGui());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }

    private IsRectVisible() {
    }
}

class IsRectVisibleGui extends JPanel {

    public static final Rectangle RECT = new Rectangle(450, 400, 100, 100);
    public static final Dimension INNER_PANEL_SIZE = new Dimension(600, 800);
    private static final Dimension SCROLLPANE_SIZE = new Dimension(250, 300);
    private static final String NOT_VISIBLE = "Not Visible";
    private static final String VISIBLE = "Visible";
    private static final long serialVersionUID = 1L;
    private InnerPanel innerPanel = new InnerPanel();
    private JViewport viewport = new JViewport();
    private JLabel statusLabel = new JLabel(NOT_VISIBLE);

    IsRectVisibleGui() {
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setViewport(viewport);
        viewport.add(innerPanel);
        scrollpane.setPreferredSize(SCROLLPANE_SIZE);
        viewport.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                Rectangle viewRect = viewport.getViewRect();
                if (viewRect.intersects(RECT)) {
                    statusLabel.setText(VISIBLE);
                } else {
                    statusLabel.setText(NOT_VISIBLE);
                }
            }
        });

        setLayout(new BorderLayout());
        add(scrollpane, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    class InnerPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        InnerPanel() {
            setPreferredSize(INNER_PANEL_SIZE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(4));
            g2.draw(RECT);
        }
    }
}