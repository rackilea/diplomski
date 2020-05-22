package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Vine implements Runnable {

    @Override
    public void run() {
        JFrame frame = new JFrame("Vine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel panel = new DrawingPanel(400, 400);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        new GrowVine(panel, 400, 400).run();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Vine());
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = -8460577623396871909L;

        private List<LineSegment> lineSegments;

        public DrawingPanel(int width, int height) {
            this.setPreferredSize(new Dimension(width, height));
            this.lineSegments = new ArrayList<>();
        }

        public void setLineSegments(List<LineSegment> lineSegments) {
            this.lineSegments = lineSegments;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);

            for (int i = 0; i < lineSegments.size(); i++) {
                LineSegment ls = lineSegments.get(i);
                Point s = ls.getStartPoint();
                Point e = ls.getEndPoint();
                g.drawLine(s.x, s.y, e.x, e.y);
            }
        }
    }

    public class GrowVine implements Runnable {

        private int width;
        private int height;

        private DrawingPanel drawingPanel;

        private List<LineSegment> lineSegments;

        public GrowVine(DrawingPanel drawingPanel, int width, int height) {
            this.drawingPanel = drawingPanel;
            this.lineSegments = new ArrayList<>();
            lineSegments.add(new LineSegment(10, 10, width - 10, height - 10));
            this.width = width;
            this.height = height;
        }

        @Override
        public void run() {
            grow(width / 2, height / 2, 200);
            drawingPanel.setLineSegments(lineSegments);
        }

        public void grow(int a, int b, int c) {
            int x = a;
            int y = b;
            int age = c;
            for (int i = 0; i <= age; i++) {
                if (coinFlip()) {
                    if (coinFlip()) {
                        grow(x, y, ((age - i) / 2));
                    }
                }

                if (coinFlip()) {
                    if (coinFlip()) {
                        lineSegments.add(new LineSegment(x, y, (x + 1), y));
                        x++;
                    } else {
                        lineSegments.add(new LineSegment(x, y, (x - 1), y));
                        x++;
                    }
                } else {
                    lineSegments.add(new LineSegment(x, y, x, (y + 1)));
                    y++;
                }
            }
        }

        private boolean coinFlip() {
            return Math.random() < 0.50D;
        }

    }

    public class LineSegment {
        private final Point startPoint;
        private final Point endPoint;

        public LineSegment(int x1, int y1, int x2, int y2) {
            this.startPoint = new Point(x1, y1);
            this.endPoint = new Point(x2, y2);
        }

        public Point getStartPoint() {
            return startPoint;
        }

        public Point getEndPoint() {
            return endPoint;
        }

    }

}