import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CreppyRectangle {

    public static void main(String[] args) {
        new CreppyRectangle();
    }

    public CreppyRectangle() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(0, 6));
                frame.add(new TestPane(Color.RED));
                frame.add(new TestPane(Color.GREEN));
                frame.add(new TestPane(Color.BLUE));
                frame.add(new TestPane(Color.ORANGE));
                frame.add(new TestPane(Color.PINK));
                frame.add(new TestPane(Color.MAGENTA));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private int yPos;
        private int size = 25 + (int)Math.round(Math.random() * 50);
        private int yDelta = 5 + (int)Math.round(Math.random() * 10);

        public TestPane(Color foreground) {
            setForeground(foreground);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    yPos += yDelta;
                    if (yPos < 0) {
                        yPos = 0;
                        yDelta *= -1;
                        System.out.println(yDelta);
                    } else if (yPos + size > getHeight()) {
                        yPos = getHeight() - size;
                        yDelta *= -1;
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getForeground());
            g2d.drawRect(0, yPos, getWidth() - 1, size);
            g2d.dispose();
        }
    }

}