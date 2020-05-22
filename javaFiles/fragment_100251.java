import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GreenRects extends JPanel {

    private static final int SCREEN_WIDTH = 500;
    private static final int SCREEN_HEIGHT = 500;

    private static final int OFFSET = 100;
    private static final int SIZE = 20;
    private static final int INC = 5;

    int[] xPoints = new int[5];

    public GreenRects() {
        int x = 0;
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] = x;
            x += OFFSET;
        }

        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < xPoints.length; i++) {
                    if (xPoints[i] + INC < SCREEN_WIDTH) {
                        xPoints[i] += INC;
                    } else {
                        xPoints[i] = 0;
                    }
                }

                repaint();
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

        g.setColor(Color.green);
        for (int i = 0; i < xPoints.length; i++) {
            g.fillRect(xPoints[i], 0, SIZE, SIZE);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new GreenRects());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}