import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Painter2 extends JPanel {

    private static final float STROKE_WIDTH = 15f;
    private static final Stroke STROKE = new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    int x, y;
    ArrayList<Point> points;

    public Painter2() {

        setBackground(Color.white);
        points = new ArrayList<>();

        MouseHandler listener = new MouseHandler();
        this.addMouseMotionListener(listener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            Point point = new Point(e.getX(), e.getY());
            points.add(point);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(STROKE);
        for (int i = 1; i < points.size(); i++) {
            int x1 = points.get(i - 1).x;
            int y1 = points.get(i - 1).y;
            int x2 = points.get(i).x;
            int y2 = points.get(i).y;
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setContentPane(new Painter2());
                f.pack();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}