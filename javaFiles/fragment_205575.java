import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawCurve extends JPanel {    
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private static final Color CURRENT_PTS_COLOR = Color.BLUE.brighter().brighter();
    public static final Color IMG_COLOR = Color.RED;
    public static final Stroke IMG_STROKE = new BasicStroke(4f);
    private static final Color FILL_COLOR = Color.WHITE;
    private BufferedImage img = null;
    private List<Point> currentPts = new ArrayList<>();

    public DrawCurve() {
        img = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setBackground(FILL_COLOR);
        g2.clearRect(0, 0, PREF_W, PREF_H);
        g2.dispose();
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, null);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(CURRENT_PTS_COLOR);
        for (int i = 1; i < currentPts.size(); i++) {
            int x1 = currentPts.get(i - 1).x;
            int y1 = currentPts.get(i - 1).y;
            int x2 = currentPts.get(i).x;
            int y2 = currentPts.get(i).y;
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            currentPts = new ArrayList<>();
            currentPts.add(e.getPoint());
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            currentPts.add(e.getPoint());
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            currentPts.add(e.getPoint());
            Graphics2D g2 = img.createGraphics();
            g2.setColor(IMG_COLOR);
            g2.setStroke(IMG_STROKE);
            for (int i = 1; i < currentPts.size(); i++) {
                int x1 = currentPts.get(i - 1).x;
                int y1 = currentPts.get(i - 1).y;
                int x2 = currentPts.get(i).x;
                int y2 = currentPts.get(i).y;
                g2.drawLine(x1, y1, x2, y2);
            }
            g2.dispose();
            currentPts.clear();
            repaint();

        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("DrawCurve");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawCurve());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}