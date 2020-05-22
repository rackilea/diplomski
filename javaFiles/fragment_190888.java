import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.java.balloontip.CustomBalloonTip;
import net.java.balloontip.examples.complete.Utils;

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

        private CustomBalloonTip customBalloonTip;

        private Rectangle square = new Rectangle(50, 50, 200, 200);

        public TestPane() {
            customBalloonTip = new CustomBalloonTip(this,
                    new JLabel("<html>I'm a " + Utils.monospace("CustomBalloonTip") + ".</html>"),
                    square,
                    Utils.createBalloonTipStyle(),
                    Utils.createBalloonTipPositioner(),
                    null);
            customBalloonTip.setVisible(false);

            addMouseMotionListener(new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {
                    if (square.contains(e.getPoint())) {
                        customBalloonTip.setVisible(true);
                    } else {
                        customBalloonTip.setVisible(false);
                    }
                }

            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fill(square);
            g2d.dispose();
        }
    }

}