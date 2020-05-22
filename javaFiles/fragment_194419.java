import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LayoutText {

    public static void main(String[] args) {
        new LayoutText();
    }

    public LayoutText() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private String text;

        public TestPane() {
            text = "A long time ago, in a galaxy, far, far away";
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setColor(Color.RED);
            g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
            g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

            Font font = new Font("Arial", Font.BOLD, 48);
            g2d.setFont(font);

            FontRenderContext frc = g2d.getFontRenderContext();
            GlyphVector gv = font.createGlyphVector(frc, "Cat");
            Rectangle2D box = gv.getVisualBounds();

            int x = 0;
            int y = (int)(((getHeight() - box.getHeight()) / 2d) + (-box.getY()));
            g2d.drawString("Cat", x, y);

            x += box.getWidth();

            gv = font.createGlyphVector(frc, "Dog");
            box = gv.getVisualBounds();

            y = (int)(((getHeight() - box.getHeight()) / 2d) + (-box.getY()));
            g2d.drawString("Dog", x, y);

            g2d.dispose();
        }
    }

}