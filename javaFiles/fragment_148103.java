import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HorseTester {

    public static void main(String[] args) {
        new HorseTester();
    }

    public HorseTester() {
        JFrame frame = new HorsePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class HorsePanel extends JFrame {

        private JPanel panel;
        private JButton reset;
        private JButton quit;
        private JButton run;
        private ActionListener listener;
        public static final int FRAME_WIDTH = 400;
        public static final int FRAME_HEIGHT = 400;

        private TrackPane trackPane;

        public HorsePanel() {

            createPanel();
            createRunRace();
            createQuit();
            setSize(FRAME_WIDTH, FRAME_HEIGHT);
        }

        public void createRunRace() {

            class RunRace implements ActionListener {

                public void actionPerformed(ActionEvent rightEvent) {
                    run.setEnabled(false);
                    trackPane.start();
                }
            }

            ActionListener a = new RunRace();
            this.run.addActionListener(a);
        }

        public void createQuit() {
            class QuitRace implements ActionListener {

                public void actionPerformed(ActionEvent rightEvent) {
                    System.exit(0);
                }
            }

            ActionListener b = new QuitRace();
            this.quit.addActionListener(b);
        }

        public void createPanel() {
            panel = new JPanel(new BorderLayout());
            trackPane = new TrackPane();
            this.run = new JButton("Run Race");
            this.quit = new JButton("Quit");
            this.reset = new JButton("Reset");
            JPanel topPanel = new JPanel();

            topPanel.setLayout(new GridLayout(1, 3));
            topPanel.add(run);
            topPanel.add(reset);
            topPanel.add(quit);
            panel.add(topPanel, BorderLayout.NORTH);
            panel.add(trackPane, BorderLayout.CENTER);

            add(panel);
        }
    }

    public class TrackPane extends JPanel {

        private static final int NUM_OF_HORSES = 5;

        private ArrayList<HorseThread> horses = new ArrayList<HorseThread>();
        private ArrayList<Thread> threads = new ArrayList<Thread>(25);

        public TrackPane() {
            setBackground(Color.GREEN);
            reset();
        }

        public void reset() {
            // Should dispose of any running threads...
            horses.clear();
            //Allocating the memory for horses
            for (int i = 0; i < NUM_OF_HORSES; i++) {
                horses.add(new HorseThread(this, i + 1));
            }
        }

        public void start() {
            // Should dispose of any running threads...
            threads.clear();
            for (int i = 0; i < horses.size(); i++) {
                Thread thread = new Thread(horses.get(i));
                thread.start();
                threads.add(thread);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (HorseThread horse : horses) {
                horse.paint(g);
            }
        }

    }

    public class HorseThread implements Runnable {

        public static final int X_START = 10;
        public static final int Y_START = 20;

        private Horse horse;
        private int xpos, ypos;
        private TrackPane track;

        public HorseThread(TrackPane track, int offset) {
            xpos = X_START;
            ypos = Y_START * offset;
            horse = new Horse(xpos, ypos);
            this.track = track;
        }

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            horse.draw(g2);
        }

        /**
         * Run method that thread executes and makes horses go across the screen
         * racing.
         */
        public void run() {
            track.repaint();
        }
    }

    public class Horse {

        private int xTop;
        private int yTop;
        public static final int RING_WIDTH = 20;

        public Horse(int x, int y) {
            xTop = x;
            yTop = y;
        }

        public void setXY(int dx, int dy) {
            xTop = dx;
            yTop = dy;
        }

        public void draw(Graphics2D g2) {
            Ellipse2D.Double horse = new Ellipse2D.Double(xTop, yTop, RING_WIDTH, RING_WIDTH);
            g2.setColor(Color.BLUE);
            g2.fill(horse);
            g2.setColor(Color.WHITE);
            g2.draw(horse);
        }
    }
}