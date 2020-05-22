import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrameHandler {

    public static void main(String[] args) {
        new FrameHandler();
    }

    public FrameHandler() {
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

    public static class TestPane extends JPanel {

        protected static final Random RANDOM_DELTA = new Random();

        private List<List<Integer>> ants;

        public TestPane() {
            Random rnd = new Random();
            ants = new ArrayList<>(25);
            for (int index = 0; index < 10; index++) {
                List<Integer> ant = new ArrayList<>(2);
                // You should also have a look at the java.awt.Point class :P
                ant.add(rnd.nextInt(200 - 2)); //x
                ant.add(rnd.nextInt(200 - 2)); //y
                ants.add(ant);
            }

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for (List<Integer> ant : ants) {
                        int xDelta = randomDelta();
                        int yDelta = randomDelta();

                        int x = ant.get(0) + xDelta;
                        int y = ant.get(1) + yDelta;

                        if (x < 0) {
                            x = 0;
                        } else if (x + 2 > getWidth()) {
                            x = getWidth() - 2;
                        }
                        if (y < 0) {
                            y = 0;
                        } else if (y + 2 > getHeight()) {
                            y = getHeight() - 2;
                        }

                        ant.set(0, x);
                        ant.set(1, y);
                    }
                    repaint();

                }
            });
            timer.start();
        }

        protected int randomDelta() {
            int delta = 0;
            do {
                double rnd = Math.random();
                delta = rnd < 0.5d ? -1 : 1;
            } while (delta == 0);
            return delta;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (List<Integer> ant : ants) {
                g2d.fillRect(ant.get(0), ant.get(1), 2, 2);
            }
            g2d.dispose();
        }

    }

}