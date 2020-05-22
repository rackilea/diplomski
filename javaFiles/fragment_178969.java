import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestMouseMove {

    public static void main(String[] args) {
        new TestMouseMove();
    }

    public TestMouseMove() {
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

        private Robot bot;
        private int position = 0;

        public TestPane() {
            try {

                bot = new Robot();
                MouseAdapter ma = new MouseAdapter() {

                    boolean ignoreMouseMove = false;

                    @Override
                    public void mouseMoved(MouseEvent e) {
                        if (!ignoreMouseMove) {
                            ignoreMouseMove = true;
                            int x = getLocationOnScreen().x + (getWidth() / 2);
                            int y = getLocationOnScreen().y + (getHeight() / 2);

                            int distanceFromCenter = e.getPoint().x - (getWidth() / 2);
                            position += distanceFromCenter;
                            if (position < 0) {
                                position = 360 - position;
                            } else if (position > 360) {
                                position -= 360;
                            }
                            repaint();

                            bot.mouseMove(x, y);
                        } else {
                            ignoreMouseMove = false;
                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.exit(0);
                    }

                };
                addMouseListener(ma);
                addMouseMotionListener(ma);
            } catch (AWTException ex) {
                ex.printStackTrace();;
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            FontMetrics fm = g2d.getFontMetrics();

            int x = getWidth() / 2;
            int y = getHeight() / 2;

            int amount = position;

            while (x > 0) {
                if (amount == position) {
                    g2d.drawLine(x, y, x, y - 40);
                } else {
                    g2d.drawLine(x, y, x, y - 20);
                }
                String text = Integer.toString(amount);
                g2d.drawString(text, x - (fm.stringWidth(text) / 2), y + fm.getHeight());
                x -= 20;
                amount--;
                if (amount < 0) {
                    amount = 360 + amount;
                }
            }
            amount = position + 1;
            x = (getWidth() / 2) + 20;
            while (x < getWidth()) {
                g2d.drawLine(x, y, x, y - 20);
                if (position > 360) {
                    position = 360 - position;
                }
                String text = Integer.toString(amount);
                g2d.drawString(text, x - (fm.stringWidth(text) / 2), y + fm.getHeight());
                x += 20;
                amount++;
            }

            g2d.dispose();
        }
    }
}