import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Asteroids extends JPanel {
    int astr1X = 50;
    int astr1Y = 30;
    int astr2X = 150;        // x and y for 3 different asteriods
    int astr2Y = 60;
    int astr3X = 250;
    int astr3Y = 45;
    private final static int OFFSET = 5;
    private final static int WIDTH = 20;
    private final static int HEIGHT = 20;
    private Timer timer = null;

    public Asteroids() {
        timer = new Timer(300, new ActionListener() {     // timer with 150 millisecond delay
            public void actionPerformed(ActionEvent e) {
                astr1Y += OFFSET;                         // add 5 t the y poistion
                astr2Y += OFFSET;
                astr3Y += OFFSET;

                repaint();
            }
        });
        timer.start();

        Action downAction = new AbstractAction() {        // slows down the timer
            public void actionPerformed(ActionEvent e) {
                int delay = timer.getDelay();
                if (delay < 1000) {
                    delay += 100;
                    timer.setDelay(delay);
                }
            }
        };

        Action upAction = new AbstractAction() {         // speeds up the timer
            public void actionPerformed(ActionEvent e) {
                int delay = timer.getDelay();
                if (delay > 100) {
                    delay -= 100;
                    timer.setDelay(delay);
                }
            }
        };

        getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");  // up key binding
        getActionMap().put("upAction", upAction);
        getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");  // down key binding
        getActionMap().put("downAction", downAction);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new Asteroids());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public Dimension getPreferredSize() {
        return new Dimension(350, 600);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (astr1Y > 590)        // if  y is size of screen
            astr1Y = 10;         // make it 0. This brings 
        if (astr2Y > 590)        // asteroid back to top
            astr2Y = 10;
        if (astr3Y > 590) 
            astr3Y = 10;


        g.fillRect(astr1X, astr1Y, WIDTH, HEIGHT);
        g.fillRect(astr2X, astr2Y, WIDTH, HEIGHT);
        g.fillRect(astr3X, astr3Y, WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}