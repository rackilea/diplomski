package com.sandbox;

import javax.swing.*;
import java.awt.*;

public class SwingSandbox {

    public static void main(String[] args) {

        JFrame frame = buildFrame();
        frame.add(new MyButton());
    }

    private static class MyButton extends JButton {


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Color color;

            if (getModel().isPressed()) {
                color = new Color(0, 0, 0);
            } else {
                color = new Color(0, 0, 255);
            }

            Graphics2D g2 = (Graphics2D) g.create();
            RenderingHints qualityHints =
                    new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHints(qualityHints);
            g2.setPaint(new GradientPaint(
                    new Point(0, 0),
                    color,
                    new Point(0, getHeight()),
                    new Color(255, 255, 0)));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            g2.dispose();


        }
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }


}