import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLine extends JPanel {

    private MouseHandler mouseHandler = new MouseHandler();
    private Point p1 = new Point(0, 0);
    private Point p2 = new Point(0, 0);
    private boolean drawing;

    //Store lines in an arraylist
    private ArrayList<Line> lines = new ArrayList<>();

    public DrawLine() {
        setBackground(Color.white);
        this.setPreferredSize(new Dimension(400, 200));
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Grid start
        g.setColor(Color.lightGray);
        int sideLength = 20;
        int nRowCount = getHeight() / sideLength;
        int currentX = sideLength;
        for (int i = 0; i < nRowCount; i++) {
            g.drawLine(0, currentX, getWidth(), currentX);
            currentX = currentX + sideLength;
        }

        int nColumnCount = getWidth() / sideLength;
        int currentY = sideLength;
        for (int i = 0; i < nColumnCount; i++) {
            g.drawLine(currentY, 0, currentY, getHeight());
            currentY = currentY + sideLength;
        }
        //Grid end

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(8,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g.drawLine(p1.x, p1.y, p2.x, p2.y);

        //draw all previous lines
        for (int i = 0; i < lines.size(); i++) { 
            g.drawLine(lines.get(i).p1.x, lines.get(i).p1.y, lines.get(i).p2.x, lines.get(i).p2.y);
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            drawing = true;
            p1 = e.getPoint();
            p2 = p1;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drawing = false;
            p2 = e.getPoint();
            repaint();
            lines.add(new Line(p1, p2));
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (drawing) {
                p2 = e.getPoint();
                repaint();
            }
        }
    }

    private void display() {
        JFrame f = new JFrame("LinePanel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DrawLine().display();
            }
        });
    }

    public class Line {
        Point p1;
        Point p2;

        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}