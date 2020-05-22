import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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

                JPanel outer = new JPanel(new BorderLayout()) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(400, 400);
                    }
                };

                outer.setBorder(new EmptyBorder(50, 50, 50, 50));

                TestPane tp = new TestPane();
                tp.setBorder(new LineBorder(Color.LIGHT_GRAY));

                outter.add(tp);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(outer);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = getWidth() - 100;
            int height = getHeight() - 100;
            int x = (getWidth() - width) / 2;
            int y = (getHeight() - height) / 2;
            g2d.setColor(Color.RED);
            g2d.drawRect(x, y, width, height);
            g2d.dispose();
        }

    }

}