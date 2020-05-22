import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/** @see http://stackoverflow.com/questions/3256941 */
public class AnimationTest extends JPanel implements ActionListener {

    private static final int WIDE = 640;
    private static final int HIGH = 480;
    private static final int RADIUS = 25;
    private static final int FRAMES = 24;
    private final Timer timer = new Timer(20, this);
    private final Rectangle rect = new Rectangle();
    private BufferedImage background;
    private int index;
    private long totalTime;
    private long averageTime;
    private int frameCount;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AnimationTest().create();
            }
        });
    }

    private void create() {
        JFrame f = new JFrame("AnimationTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        timer.start();
    }

    public AnimationTest() {
        super(true);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(WIDE, HIGH));
        this.addMouseListener(new MouseHandler());
        this.addComponentListener(new ComponentHandler());
    }

    @Override
    protected void paintComponent(Graphics g) {
        long start = System.nanoTime();
        super.paintComponent(g);
        int w = this.getWidth();
        int h = this.getHeight();
        g.drawImage(background, 0, 0, this);
        double theta = 2 * Math.PI * index++ / 64;
        g.setColor(Color.blue);
        rect.setRect(
            (int) (Math.sin(theta) * w / 3 + w / 2 - RADIUS),
            (int) (Math.cos(theta) * h / 3 + h / 2 - RADIUS),
            2 * RADIUS, 2 * RADIUS);
        g.fillOval(rect.x, rect.y, rect.width, rect.height);
        g.setColor(Color.white);
        if (frameCount == FRAMES) {
            averageTime = totalTime / FRAMES;
            totalTime = 0; frameCount = 0;
        } else {
            totalTime += System.nanoTime() - start;
            frameCount++;
        }
        String s = String.format("%1$5.3f", averageTime / 1000000d);
        g.drawString(s, 5, 16);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            JTextField field = new JTextField("test");
            Dimension d = field.getPreferredSize();
            field.setBounds(e.getX(), e.getY(), d.width, d.height);
            add(field);
        }
    }

    private class ComponentHandler extends ComponentAdapter {

        private final GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        private final GraphicsConfiguration gc =
            ge.getDefaultScreenDevice().getDefaultConfiguration();
        private final Random r = new Random();

        @Override
        public void componentResized(ComponentEvent e) {
            super.componentResized(e);
            int w = getWidth();
            int h = getHeight();
            background = gc.createCompatibleImage(w, h, Transparency.OPAQUE);
            Graphics2D g = background.createGraphics();
            g.clearRect(0, 0, w, h);
            g.setColor(Color.green.darker());
            for (int i = 0; i < 128; i++) {
                g.drawLine(w / 2, h / 2, r.nextInt(w), r.nextInt(h));
            }
            g.dispose();
            System.out.println("Resized to " + w + " x " + h);
        }
    }
}