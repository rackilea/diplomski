package com.src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Matrix3d;

public class TestFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public TestFrame() {
        initComponents();
    }

    public void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(new Point((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 400, (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 250));
        setSize(500, 500);
        setVisible(true);

        CompassPanel c = new CompassPanel();
        add(c, BorderLayout.CENTER);

    }

    public class CompassPanel extends JPanel {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private int circleX, circleY, circleRadius;
        private int[] xPoints, yPoints;

        public CompassPanel() {
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;

            AffineTransform a = new AffineTransform();
            a.translate(getWidth() / 2.0, getHeight() / 2.0);
            g2d.transform(a);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            circleRadius = (int) (getWidth() * 0.7);
            circleX = (int) (-circleRadius * 0.5);
            circleY = (int) (-circleRadius * 0.5);

            g2d.setColor(Color.BLACK);
            for (int angle = -45; angle <= 315; angle += 5) {
                double sin = Math.sin(Math.toRadians(angle));
                double cos = Math.cos(Math.toRadians(angle));
                int x1 = (int) ((circleX + circleRadius / 2) - cos * (circleRadius * 0.37) - sin * (circleRadius * 0.37));
                int y1 = (int) ((circleY + circleRadius / 2) + sin * (circleRadius * 0.37) - cos * (circleRadius * 0.37));
                g.setColor(Color.BLACK);
                g.drawLine(x1, y1, (circleX + circleRadius / 2), (circleY + circleRadius / 2));
            }

            g2d.setFont(new Font("Arial", Font.BOLD, 11));
            g2d.drawString("WEST", circleX - 40, circleY + circleRadius / 2 + 4);
            g2d.drawString("EAST", circleX + circleRadius + 13, circleY + circleRadius / 2 + 4);
            g2d.drawString("NORTH", circleX + circleRadius / 2 - 14, circleY - 15);
            g2d.drawString("SOUTH", circleX + circleRadius / 2 - 14, circleY + circleRadius + 25);
            g2d.setColor(Color.WHITE);
            g2d.fillOval(circleX, circleY, circleRadius, circleRadius);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(circleX, circleY, circleRadius, circleRadius);

            xPoints = new int[] { (int) (circleX + circleRadius / 2), (int) (circleX + circleRadius * 0.25), (int) (circleX + circleRadius / 2), (int) (circleX + circleRadius * 0.75) };
            yPoints = new int[] { (int) (circleY + 30), (int) (circleY + circleRadius * 0.85), (int) (circleY + circleRadius * 0.6), (int) (circleY + circleRadius * 0.85) };
            int angle =30;
            xPoints = rotateXPoints(xPoints, yPoints, angle);
            yPoints = rotateYPoints(xPoints, yPoints, angle);

            g2d.setColor(Color.RED);
            g2d.fillPolygon(xPoints, yPoints, 4);
            g2d.setColor(Color.black);
            Polygon p = new Polygon(xPoints, yPoints, 4);

            // g2d.drawPolygon(xPoints, yPoints, 4);
            g2d.draw(p);

            g2d.setColor(Color.GREEN);
            g2d.fillOval(-3, -3, 6, 6);

        }
        public int[] rotateXPoints(int[] xPoints,int[] yPoints,int angle) {
            for (int i = 0; i < xPoints.length; i++) {
                Point p = new Point(xPoints[i], yPoints[i]);
                p = rotatePoint(p, new Point(0, 0), angle);
                xPoints[i] = p.x;
            }
            return xPoints;

        }
        public int[] rotateYPoints(int[] xPoints,int[] yPoints,int angle) {
            for (int i = 0; i < yPoints.length; i++) {
                Point p = new Point(xPoints[i], yPoints[i]);
                p = rotatePoint(p, new Point(0, 0), angle);
                yPoints[i] = p.y;
            }
            return yPoints;

        }
        public Point rotatePoint(Point pt, Point center, double angle)
        {
            angle = ((angle/180)*Math.PI);
            double cosAngle = Math.cos(angle);
            double sinAngle = Math.sin(angle);

            pt.x = center.x + (int) ((pt.x-center.x)*cosAngle-(pt.y-center.y)*sinAngle);
            pt.y = center.y + (int) ((pt.x-center.x)*sinAngle+(pt.y-center.y)*cosAngle);
            return pt;
        }
    }


    public static void main(String[] args) {
        new TestFrame();
    }
}