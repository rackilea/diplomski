import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.AbstractBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TextOutline {

    public static void main(String[] args) {
        new TextOutline();
    }

    public TextOutline() {
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

    public class RainbowBorder extends AbstractBorder {

        @Override
        public Insets getBorderInsets(Component c) {
            return super.getBorderInsets(c); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.bottom = insets.top = insets.left = insets.right = 1;
            return insets;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            LinearGradientPaint lpg = new LinearGradientPaint(
                new Point(x, y),
                new Point(x, y + height),
                new float[]{0.0f, 0.25f, 0.5f, 0.75f, 1.0f},
                new Color[]{Color.YELLOW,    Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA});
            g2d.setPaint(lpg);
            g2d.draw(new Rectangle2D.Double(x, y, width - 1, height - 1));
            g2d.dispose();
        }

    }

    class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            setBorder(
                new CompoundBorder(
                    new EmptyBorder(10, 10, 10, 10),
                    new CompoundBorder(
                        new RainbowBorder(), 
                        new EmptyBorder(10, 10, 10, 10))
            ));
            add(new JLabel("Rainbow and unicorns"));
        }
    }
}