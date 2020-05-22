package com.ggl.testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DijkstraUI extends JComponent {
    private static final long serialVersionUID = 8838700175925828779L;

    private static MyMouseListener listener;

    private DijkstraModel model;

    public DijkstraUI() {
        this.model = new DijkstraModel();
        listener = new MyMouseListener(this, model);
    }

    public static void main(String args[]) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Dijkstra: Finding the shortest path");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                DijkstraUI dj = new DijkstraUI();
                dj.addMouseListener(listener);
                frame.getContentPane().add(dj);

                frame.setSize(400, 400);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        };

        SwingUtilities.invokeLater(runnable);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (MyEllipse ellipse : model.getEllipseList()) {
            g2d.setPaint(Color.WHITE);
            Ellipse2D ellipse2d = ellipse.getEllipse();
            g2d.fill(ellipse2d);
            g2d.setPaint(Color.BLACK);
            g2d.drawString(ellipse.getLabel(),
                    (int) ellipse2d.getCenterX() - 5,
                    (int) ellipse2d.getCenterY() + 6);
        }

        for (MyLine myLine : model.getLineList()) {
            g2d.setPaint(Color.BLUE);
            g2d.drawLine(myLine.getFromPoint().x, myLine.getFromPoint().y,
                    myLine.getToPoint().x, myLine.getToPoint().y);
        }
    }

    public class MyMouseListener implements MouseListener {

        private JComponent component;

        private DijkstraModel model;

        private Point fromPoint;

        public MyMouseListener(JComponent component, DijkstraModel model) {
            this.component = component;
            this.model = model;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            Point2D p2d = new Point2D.Double((double) p.x, (double) p.y);
            p = getCenterPoint(p2d);
            if (p.x >= 0) {
                fromPoint = p;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point p = e.getPoint();
            Point2D p2d = new Point2D.Double((double) p.x, (double) p.y);
            p = getCenterPoint(p2d);
            if (p.x >= 0) {
                model.addMyLine(new MyLine(fromPoint, p));
                component.repaint();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        private Point getCenterPoint(Point2D mousePoint) {
            for (MyEllipse ellipse : model.getEllipseList()) {
                Ellipse2D ellipse2d = ellipse.getEllipse();
                if (ellipse2d.contains(mousePoint)) {
                    Point p = new Point((int) ellipse2d.getCenterX(),
                            (int) ellipse2d.getCenterY());
                    return p;
                }
            }

            return new Point(-1, -1);
        }

    }

    public class DijkstraModel {
        private List<MyEllipse> ellipseList;
        private List<MyLine> lineList;

        public DijkstraModel() {
            this.ellipseList = new ArrayList<>();

            this.ellipseList.add(new MyEllipse("0", new Ellipse2D.Double(50,
                    120, 50, 50)));
            this.ellipseList.add(new MyEllipse("1", new Ellipse2D.Double(150,
                    45, 50, 50)));
            this.ellipseList.add(new MyEllipse("2", new Ellipse2D.Double(150,
                    150, 50, 50)));
            this.ellipseList.add(new MyEllipse("3", new Ellipse2D.Double(260,
                    120, 50, 50)));
            this.ellipseList.add(new MyEllipse("4", new Ellipse2D.Double(100,
                    240, 50, 50)));
            this.ellipseList.add(new MyEllipse("5", new Ellipse2D.Double(200,
                    250, 50, 50)));

            this.lineList = new ArrayList<>();
        }

        public List<MyEllipse> getEllipseList() {
            return Collections.unmodifiableList(ellipseList);
        }

        public void addMyLine(MyLine myLine) {
            this.lineList.add(myLine);
        }

        public List<MyLine> getLineList() {
            return Collections.unmodifiableList(lineList);
        }

    }

    public class MyEllipse {
        private final String label;
        private final Ellipse2D ellipse;

        public MyEllipse(String label, Ellipse2D ellipse) {
            this.label = label;
            this.ellipse = ellipse;
        }

        public String getLabel() {
            return label;
        }

        public Ellipse2D getEllipse() {
            return ellipse;
        }

    }

    public class MyLine {
        private final Point fromPoint;
        private final Point toPoint;

        public MyLine(Point fromPoint, Point toPoint) {
            this.fromPoint = fromPoint;
            this.toPoint = toPoint;
        }

        public Point getFromPoint() {
            return fromPoint;
        }

        public Point getToPoint() {
            return toPoint;
        }

    }
}