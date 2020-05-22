import fr.theshark34.swinger.textured.STexturedButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            try {
                STexturedButton btn = new STexturedButton(ImageIO.read(getClass().getResource("/Pony.png")));
                add(btn);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            LinearGradientPaint lgp = new LinearGradientPaint(
                    new Point(0, 0),
                    new Point(0, getHeight()),
                    new float[]{
                        0.1428571428571429f,
                        0.2857142857142858f,
                        0.4285714285714287f,
                        0.5714285714285716f,
                        0.7142857142857145f,
                        0.8571428571428574f,
                        1f
                    },
                    new Color[]{Color.RED, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.BLUE, Color.MAGENTA, Color.PINK}
            );
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setPaint(lgp);
            g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
            g2d.dispose();
        }

    }

}