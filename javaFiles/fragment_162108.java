import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class Painter2 extends JPanel {

    private static final float STROKE_WIDTH = 15f;
    private static final Stroke STROKE = new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND);
    private static final Color CURVES_COLOR = Color.BLUE;
    private static final Color TEMP_CURVE_COLOR = Color.PINK;
    private List<List<Point>> curvesList = new ArrayList<>();
    private List<Point> tempCurve = null;

    public Painter2() {
        setBackground(Color.white);
        MouseHandler listener = new MouseHandler();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        @Override
        public void mousePressed(MouseEvent e) {
            tempCurve = new ArrayList<>();
            tempCurve.add(e.getPoint());
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            tempCurve.add(e.getPoint());
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            tempCurve.add(e.getPoint());
            curvesList.add(tempCurve);
            tempCurve = null;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(STROKE);
        g2.setColor(CURVES_COLOR);
        for (List<Point> curve : curvesList) {
            drawCurve(g2, curve);
        }

        if (tempCurve != null) {
            g2.setColor(TEMP_CURVE_COLOR);
            drawCurve(g2, tempCurve);
        }

        g2.dispose();
    }

    private void drawCurve(Graphics2D g2, List<Point> ptList) {
        for (int i = 1; i < ptList.size(); i++) {
            int x1 = ptList.get(i - 1).x;
            int y1 = ptList.get(i - 1).y;
            int x2 = ptList.get(i).x;
            int y2 = ptList.get(i).y;
            g2.drawLine(x1, y1, x2, y2);
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