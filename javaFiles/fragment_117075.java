import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class RectangleDraw extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private static final Color TEMP_RECT_COLOR = Color.LIGHT_GRAY;
    private static final Color SHAPE_COLOR = Color.RED;
    private Rectangle tempRect = null;
    private List<Shape> shapes = new ArrayList<>();

    public RectangleDraw() {
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw the temporary rectangle if not null
        if (tempRect != null) {
            g2.setColor(TEMP_RECT_COLOR);
            g2.draw(tempRect);
        }

        // draw all the rectangles in the list
        g2.setColor(SHAPE_COLOR);
        for (Shape shape : shapes) {
            g2.draw(shape);
        }

    }

    // size the GUI to my specification
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    // My mouse listener and mouse motion listener
    private class MyMouse extends MouseAdapter {
        private Point p1; // start point

        @Override
        public void mousePressed(MouseEvent e) {
            p1 = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // create temporary rectangle
            tempRect = createRectangle(e);
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            tempRect = null; // null temp rectangle and
            // add rectangle to List
            shapes.add(createRectangle(e));
            repaint();
        }

        // create a rectangle from start point and current point
        private Rectangle createRectangle(MouseEvent e) {
            Point p2 = e.getPoint();
            int x = Math.min(p1.x, p2.x);
            int y = Math.min(p1.y, p2.y);
            int w = Math.abs(p1.x - p2.x);
            int h = Math.abs(p1.y - p2.y);
            Rectangle rect = new Rectangle(x, y, w, h);
            return rect;
        }

    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Rectangle Draw");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RectangleDraw());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}