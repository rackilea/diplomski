import java.awt.*;
import javax.swing.*;

public class Oblig1 {

    JFrame frame;
    JPanel infoPanel;
    DrawingPanel drawPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Oblig1();
            }
        });
    }

    public Oblig1() {
        frame = new JFrame("Parachute Game");
        //frame.setSize(860, 640);
        infoPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(20, 20);
            }
        };
        drawPanel = new DrawingPanel();

        infoPanel.setBackground(Color.yellow);
        //drawPanel.setPreferredSize(new Dimension(840, 20));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
        //drawPanel.setPreferredSize(new Dimension(840, 620));
        frame.getContentPane().add(infoPanel, BorderLayout.NORTH);
        frame.getContentPane().add(drawPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    //This class represents the panel that paints all animated parts of the game
    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = 1L;

        public DrawingPanel() {
            setDoubleBuffered(true);
        }

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(300, 300);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.MAGENTA);
            //g2d.fillRect(0, 0, getHeight(), getWidth());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}