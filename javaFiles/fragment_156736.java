import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
                frame.add(new TestPane(new Rectangle(150, 150, 50, 50)));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Rectangle boxIn;

        public TestPane(Rectangle boxIn) {
            this.boxIn = boxIn;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            String text = "Hello";
            FontMetrics fm = g2d.getFontMetrics();

            int x = boxIn.x + ((boxIn.width - fm.stringWidth(text)) / 2);
            int y = boxIn.y + (((boxIn.height - fm.getHeight()) / 2) + fm.getAscent());

            g2d.setColor(Color.BLUE);
            g2d.fill(boxIn);
            g2d.setColor(Color.WHITE);
            g2d.drawString(text, x, y);

            g2d.dispose();
        }

    }

}