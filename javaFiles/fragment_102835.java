import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class Distance extends JFrame implements Runnable {

    private double x1, y1;
    private double x2, y2;
    private double width, height;

    private double dx, dy;

    public Distance() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        init();
    }

    private void init() {
        x1 = y1 = 100;
        x2 = 450;
        y2 = 500;
        width = height = 20;

        dx = x2 - x1;
        dy = y2 - y1;

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int)x1, (int)y1, (int)width, (int)height);
        g.fillOval((int)x2, (int)y2, (int)width, (int)height);
        repaint();
    }

    private void tick() {
        double moveX = (dx / 100) * 1;
        double moveY = (dy / 100) * 1;
        x1 += moveX;
        y1 += moveY;
    }

    @Override
    public void run() {
        while(true) {
            try {
                tick();
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }

    public static void main(String[] args) {
        new Distance();
    }
}