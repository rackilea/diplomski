package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CircleSprite implements Runnable {

    private BufferedImage circle;

    private DrawingPanel drawingPanel;

    private JFrame frame;

    @Override
    public void run() {
        circle = createCircle();

        frame = new JFrame("Circle Sprite");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new DrawingPanel(circle);
        frame.add(drawingPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        new Thread(new RandomDraw(drawingPanel)).start();
    }

    private BufferedImage createCircle() {
        BufferedImage image = new BufferedImage(100, 100, 
            BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 100, 100);
        g.setColor(Color.BLUE);
        g.fillOval(10, 10, 80, 80);
        g.dispose();

        return image;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CircleSprite());
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = -4603711384104715819L;

        private int x;
        private int y;

        private BufferedImage image;

        public DrawingPanel(BufferedImage image) {
            this.image = image;
            this.x = 0;
            this.y = 0;
            setPreferredSize(new Dimension(500, 500));
        }

        public void setPoint(int x, int y) {
            this.x = x;
            this.y = y;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, x, y, null);
        }

    }

    public class RandomDraw implements Runnable {

        private DrawingPanel drawingPanel;

        private Random random;

        public RandomDraw(DrawingPanel drawingPanel) {
            this.drawingPanel = drawingPanel;
            this.random = new Random();
        }

        @Override
        public void run() {
            while (true) {
                sleep();
                int x = random.nextInt(400);
                int y = random.nextInt(400);
                drawingPanel.setPoint(x, y);
            }
        }

        private void sleep() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {

            }
        }

    }

}