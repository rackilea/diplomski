import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Glasspanetest extends JFrame {

    public JFrame init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        GraphicsPanel jp = new GraphicsPanel();
        add(jp, BorderLayout.CENTER);
        LabelGlassPane glass = new LabelGlassPane();
        this.setGlassPane(glass);
        glass.setVisible(true);
        setSize(400, 400);
        return this;
    }

    class GraphicsPanel extends JPanel {

        private Shape oval = new Ellipse2D.Double(50, 50, 50, 50);

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (g.getClip().intersects(oval.getBounds2D())) {
                g.setColor(Color.red);
                ((Graphics2D) g).fill(oval);
                System.out.println("Painting bottom panel");
            }
        }
    }

    public Ellipse2D.Double ell = null;

    class LabelGlassPane extends JComponent {
        public LabelGlassPane() {
            this.addMouseMotionListener(new MoveInfoListener());
        }

        public class MoveInfoListener implements MouseMotionListener {
            @Override
            public void mouseMoved(MouseEvent e) {
                Ellipse2D.Double oldEll = ell;
                ell = new Ellipse2D.Double(e.getX() - 3, e.getY() - 3, 6, 6);
                LabelGlassPane.this.repaint(oldEll, ell);
            }

            @Override
            public void mouseDragged(MouseEvent arg0) {
            }
        }

        public void repaint(Double oldEll, Double ell) {
            Rectangle rect = ell.getBounds();
            if (oldEll != null) {
                rect = rect.union(oldEll.getBounds());
            }
            // repaint(rect);
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            // g.setColor(Color.red);
            // Container root = frame.getRootPane();
            // g.setColor(new Color(255,100,100,100));
            // g.fillRect(100, 100, 500, 500);
            if (ell != null) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(Color.black);
                g2.fill(ell);
                System.out.println("Painted glass pane");
            }

            // rPaint(root,g);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Glasspanetest().init().setVisible(true);
            }
        });
    }

}