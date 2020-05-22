import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyTaskToo extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private Color circleColor = Color.RED;
    private int circX  = 10;
    private int circY = circX;
    private int circW = PREF_W - 2 * circX;
    private int circH = PREF_H - 2 * circY;

    public MyTaskToo() {
        // add in constructor -- in the "instance realm" not in the static realm
        addMouseListener(new MyMouse());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // to smooth out graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(circleColor);
        g2.fillOval(circX, circY, circW, circH);

        g2.setColor(Color.BLACK);
        g2.drawOval(circX, circY, circW, circH);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouse extends MouseAdapter {
        Random rand = new Random();

        @Override
        public void mousePressed(MouseEvent e) {
            float red = rand.nextFloat();
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            circleColor = new Color(red, green, blue);
            repaint();
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("MyTaskToo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyTaskToo());
        frame.pack();
        frame.setLocationRelativeTo(null);
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