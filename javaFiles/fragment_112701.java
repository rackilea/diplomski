package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Stars implements Runnable {

    private StarModel starModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Stars());
    }

    public Stars() {
        this.starModel = new StarModel();
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Draw Stars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawingPanel(starModel));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = -1701342603243093672L;

        public DrawingPanel(StarModel starModel) {
            this.setPreferredSize(new Dimension(StarModel.DRAWING_WIDTH,
                    StarModel.DRAWING_HEIGHT));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            for (Star star : starModel.getStarList()) {
                g.setColor(star.getColor());
                g.fillPolygon(star.getStar());
            }
        }
    }

    public class StarModel {
        public static final int DRAWING_WIDTH = 400;
        public static final int DRAWING_HEIGHT = 400;

        private List<Star> starList;

        public StarModel() {
            this.starList = new ArrayList<>();
            for (int y = 80; y <= 320; y += 80) {
                for (int x = 80; x <= 320; x += 80) {
                    Point p = new Point(x, y);
                    this.starList.add(new Star(p, 36, Color.BLUE));
                }
            }
        }

        public List<Star> getStarList() {
            return starList;
        }
    }

    public class Star {
        private final int radius;

        private final Color color;

        private final Point origin;

        private Polygon star;

        public Star(Point origin, int radius, Color color) {
            this.origin = origin;
            this.radius = radius;
            this.color = color;
            this.star = createStar();
        }

        private Polygon createStar() {
            Polygon polygon = new Polygon();
            double smallRadius = 0.38D * radius;
            addPoint(polygon, createPoint(origin, radius, 270D));
            addPoint(polygon, createPoint(origin, smallRadius, 306D));
            addPoint(polygon, createPoint(origin, radius, 342D));
            addPoint(polygon, createPoint(origin, smallRadius, 18D));
            addPoint(polygon, createPoint(origin, radius, 54D));
            addPoint(polygon, createPoint(origin, smallRadius, 90D));
            addPoint(polygon, createPoint(origin, radius, 126D));
            addPoint(polygon, createPoint(origin, smallRadius, 162D));
            addPoint(polygon, createPoint(origin, radius, 198D));
            addPoint(polygon, createPoint(origin, smallRadius, 234D));
            return polygon;
        }

        private Point2D createPoint(Point origin, double radius, double angle) {
            double radians = Math.toRadians(angle);
            double x = Math.cos(radians) * radius + origin.x;
            double y = Math.sin(radians) * radius + origin.y;
            return new Point2D.Double(x, y);
        }

        private void addPoint(Polygon polygon, Point2D point) {
            int x = (int) Math.round(point.getX());
            int y = (int) Math.round(point.getY());
            polygon.addPoint(x, y);
        }

        public int getRadius() {
            return radius;
        }

        public Point getOrigin() {
            return origin;
        }

        public Color getColor() {
            return color;
        }

        public Polygon getStar() {
            return star;
        }

    }

}