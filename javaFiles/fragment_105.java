import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class PieDemo extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final Color BG = Color.WHITE;
    private static final int GAP = 40;
    public static final int TIMER_DELAY = 400;
    private int redPercent = 0;
    private int bluePercent = 0;
    // green will be remainder

    public PieDemo() {
        setBackground(BG);
        add(new JButton(new StartDemoAction("Start", KeyEvent.VK_S)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int redAngle = (redPercent * 360) / 100;
        int blueAngle = (bluePercent * 360) / 100;
        int greenAngle = 360 - redAngle - blueAngle;
        greenAngle = Math.max(greenAngle, 0);
        int startAngle = 0;
        startAngle = drawPie(g, Color.green, startAngle, greenAngle);
        startAngle = drawPie(g, Color.RED, startAngle, redAngle);
        startAngle = drawPie(g, Color.BLUE, startAngle, blueAngle);
    }

    private int drawPie(Graphics g, Color color, int startAngle, int arcAngle) {
        int x = GAP;
        int y = GAP;
        int w = getWidth() - 2 * GAP;
        int h = getHeight() - 2 * GAP;
        g.setColor(color);
        g.fillArc(x, y, w, h, startAngle, arcAngle);
        return startAngle + arcAngle;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class StartDemoAction extends AbstractAction {
        private Timer timer = null;
        public StartDemoAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (timer != null && timer.isRunning()) {
                return;
            }
            redPercent = 0;
            bluePercent = 0;
            repaint();
            timer = new Timer(TIMER_DELAY, new TimerListener());
            timer.start();
        }
    }

    private class TimerListener implements ActionListener {
        private static final int BOUND = 10;
        private Random random = new Random();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (redPercent + bluePercent >= 100) {
                ((Timer) e.getSource()).stop();
            } else {
                redPercent += random.nextInt(BOUND);
                bluePercent += random.nextInt(BOUND / 2);

                if (redPercent + bluePercent > 100) {
                    bluePercent = 100 - redPercent;
                }
                repaint();
            }
        }
    }

    private static void createAndShowGui() {
        PieDemo mainPanel = new PieDemo();

        JFrame frame = new JFrame("PieDemo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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