import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

    public Example() {

        JFrame frame = new JFrame();

        frame.setContentPane(new DrawingPanel());

        frame.setSize(400, 300);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

    }

    class DrawingPanel extends JPanel {

        int angle = 0;
        int rotation = 0;
        int radius = 150;

        int ovalX = 150;
        int ovalY = 150;
        int ovalWidth = 100;
        int ovalHeight = 100;
        int ovalCenterX = ovalX + ovalWidth / 2;
        int ovalCenterY = ovalY + ovalHeight / 2;

        int recX;
        int recY;
        int recWidth = 50;
        int recHeight = 50;
        int recCenterX;
        int recCenterY;

        int WORLD_SIZE_X = 6000;
        int WORLD_SIZE_Y = 6000;

        int camX;
        int camY;

        public DrawingPanel() {

            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle++;
                    rotation++;
                    recCenterX = (int) ((int) ovalCenterX + Math.sin(Math.toRadians(angle)) * radius);
                    recCenterY = (int) ((int) ovalCenterY + Math.cos(Math.toRadians(angle)) * radius);
                    recX = recCenterX - recWidth / 2;
                    recY = recCenterY - recHeight / 2;
                    repaint();
                }
            };

            Timer timer = new Timer(15, al);
            timer.start();

        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            Graphics2D gg = (Graphics2D) g;
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int VIEWPORT_SIZE_X = getWidth();
            int VIEWPORT_SIZE_Y = getHeight();

            int offsetMaxX = WORLD_SIZE_X - VIEWPORT_SIZE_X;
            int offsetMaxY = WORLD_SIZE_Y - VIEWPORT_SIZE_Y;

            camX = recCenterX - VIEWPORT_SIZE_X / 2;
            camY = recCenterY - VIEWPORT_SIZE_Y / 2;

            if (camX > offsetMaxX) {
                camX = offsetMaxX;
            }

            if (camY > offsetMaxY) {
                camY = offsetMaxY;
            }

            gg.translate(-camX, -camY);

            gg.setColor(Color.BLUE);
            gg.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);

            AffineTransform old = gg.getTransform();

            gg.rotate(Math.toRadians(rotation), recCenterX, recCenterY);
            gg.setColor(Color.RED);
            gg.drawRect(recX, recY, recWidth, recHeight);

            gg.setTransform(old);

            gg.setColor(Color.GREEN);
            gg.drawLine(ovalCenterX, ovalCenterY, recCenterX, recCenterY);

        }

    }

}