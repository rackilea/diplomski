import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(new DrawingPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DrawingPanel extends JPanel {

        public DrawingPanel() {
            setBorder(new EmptyBorder(8, 8, 8, 8));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();
            Insets insets = getInsets();
            g2d.translate(insets.top, insets.left);

            int width = getWidth() - 1 - (insets.left + insets.right);
            int height = getHeight() - 1 - (insets.top + insets.bottom);

            int vHalf = height / 2;
            int hHalf = width / 2;
            int vPos = vHalf / 4;
            int hPos = hHalf / 4;

            int[] xpoints = {
                0,
                hHalf - hPos,
                hHalf + hPos,
                width,
                width,
                hHalf + hPos,
                hHalf - hPos,
                0
            };
            int[] ypoints = {
                vHalf - vPos,
                0,
                0, 
                vHalf - vPos,
                vHalf + vPos,
                height,
                height,
                vHalf + vPos,
            };

            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(xpoints, ypoints, xpoints.length);
            g2d.dispose();
        }
    }

}