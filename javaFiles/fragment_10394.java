package com.ggl.triangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

//********************************************************************
//*** This is a stripped down version of the code which shows      ***
//*** the problem. Just create an instance of the class by running *** 
//*** TriangleFrame.java. Then try to drag either triangle with    ***
//*** the mouse.                                                   ***
//********************************************************************
public class TrianglePanel extends JPanel implements MouseListener,
        MouseMotionListener {

    private static final long serialVersionUID = 5615435125201426466L;

    private static final boolean DEBUG = false;

    private List<Triangle> triangles;

    private Triangle dragTriangle;

    private int originalXPos = 0;
    private int originalYPos = 0;

    private boolean draggable = false;

    public TrianglePanel() {
        setPreferredSize(new Dimension(600, 400));

        triangles = new ArrayList<>();
        triangles.add(new Triangle(Color.RED, new Point(100, 10), new Point(50,
                100), new Point(150, 100)));
        triangles.add(new Triangle(Color.BLUE, new Point(350, 10), new Point(
                250, 100), new Point(450, 100)));

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggable) {
            repaint();
        }

        this.originalXPos = 0;
        this.originalYPos = 0;

        this.draggable = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.draggable = false;

        Point p = e.getPoint();
        if (DEBUG) {
            System.out.println("mousePressed: x: " + p.x + ", y: " + p.y);
        }

        for (Triangle triangle : triangles) {
            if (DEBUG) {
                System.out.println(triangle);
            }

            if (triangle.contains(p.x, p.y)) {
                if (DEBUG) {
                    System.out.println("Mouse pressed point is contained "
                            + "in the triangle");
                }

                originalXPos = p.x;
                originalYPos = p.y;
                dragTriangle = triangle;
                draggable = true;
                break;
            } else {
                if (DEBUG) {
                    System.out.println("Mouse pressed point is not "
                            + "contained in the triangle");
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggable) {
            dragTriangle.moveTriangle(e.getX() - originalXPos, e.getY()
                    - originalYPos);
            originalXPos = e.getX();
            originalYPos = e.getY();

            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Triangle triangle : triangles) {
            triangle.draw(g);
        }
    }

    // not used
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * 
     * Inner Triangle Class. A polygon object is used for convenience to create
     * the Triangle. Otherwise I would have to deal with Points all through the
     * program. Which means 3 coordinate pairs = 6 coordinates, which means more
     * code.
     * 
     */
    private class Triangle {

        private Color color;

        private Polygon polygon;

        private Triangle(Color color, Point p1, Point p2, Point p3) {
            this.color = color;

            polygon = new Polygon();
            polygon.addPoint(p1.x, p1.y);
            polygon.addPoint(p2.x, p2.y);
            polygon.addPoint(p3.x, p3.y);
        }

        public boolean contains(int x, int y) {
            return polygon.contains(x, y);
        }

        public void moveTriangle(int x, int y) {
            polygon.translate(x, y);
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillPolygon(polygon);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Triangle [polygon=");
            polygonToString(builder, polygon);
            builder.append("]");

            return builder.toString();
        }

        private void polygonToString(StringBuilder builder, Polygon polygon) {
            for (int i = 0; i < polygon.npoints; i++) {
                Point p = new Point(polygon.xpoints[i], polygon.ypoints[i]);
                builder.append(p);
                if (i < (polygon.npoints - 1)) {
                    builder.append(",");
                } else {
                    builder.append("]");
                }
            }
        }

    } // end inner class Triangle

} // end outer class TrianglePanel