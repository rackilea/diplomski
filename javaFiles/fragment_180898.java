import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;

final class TestCanvas extends JComponent {

    int size = 200;
    int n = 10;
    float[] ph = new float[n];
    float[] pw = new float[n];
    float[] px = new float[n];
    Random gen = new Random();

    TestCanvas() {
        makeRandomParabolas();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                makeRandomParabolas();
                repaint();
                float [] coords = new float [6];
                for (int i = 0; i < n; i++) {
                    PathIterator pi = getQuadCurve(i).getPathIterator(null, 0.1);
                    System.out.print(i + ":");
                    while (!pi.isDone()) {
                        switch (pi.currentSegment(coords)) {
                            case PathIterator.SEG_MOVETO:
                                System.out.print(" move to");
                                break;
                            case PathIterator.SEG_LINETO:
                                System.out.print(" line to");
                                break;
                            default:
                                System.out.print(" unexpected");
                                break;
                        }
                        System.out.println(" (" + coords[0] + "," + coords[1]+")");
                        pi.next();
                    }
                    System.out.println();
                }
            }
        });
    }

    QuadCurve2D.Float getQuadCurve(int i) {
        return new QuadCurve2D.Float(px[i] - pw[i], size,
                px[i], size - (2 * ph[i]),
                px[i] + pw[i], size);
    }

    void makeRandomParabolas() {
        for (int i = 0; i < n; i++) {
            float x = 0.2f + 0.6f * gen.nextFloat();
            px[i] = size * x;
            pw[i] = size * (Math.min(x, 1 - x) * gen.nextFloat());
            ph[i] = size * (0.5f + 0.5f * gen.nextFloat());
        }
    }

    @Override
    protected void paintComponent(Graphics g0) {
        Graphics2D g = (Graphics2D) g0;
        for (int i = 0; i < n; i++) {
            g.draw(getQuadCurve(i));
        }
    }
}

public class Main extends JFrame {

    public Main() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new TestCanvas());
        getContentPane().setPreferredSize(new Dimension(200, 200));
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}