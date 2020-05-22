Here is a rework of your code:

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CourtCanvas extends JPanel {
    private int courtHeight = 100;
    private int courtWidth = 200;
    private int left = 10;
    private int top = 10;
    private Point center = new Point();

    private Color bgColor = new Color(52, 153, 204);
    private Color lineColor = new Color(255, 255, 255);
    private Color floorColor = new Color(255, 153, 0);

    private OrientationRequested orientation;
    private Point[] localCoords = new Point[5];
    private Point[] visitCoords = new Point[5];

    public CourtCanvas() {
        calcDimensions();
        setBackground(bgColor);

        for (int i = 0; i < localCoords.length; i++) {
            localCoords[i] = new Point();
            visitCoords[i] = new Point();
        }
    }

    private void calcDimensions() {
        if (this.getHeight() > this.getWidth()) {
            orientation = OrientationRequested.PORTRAIT;
            courtHeight = (int) Math.min(this.getHeight() * 0.9, this.getWidth() * 1.8);
            courtWidth = (int) (courtHeight / 2.0);
        } else {
            orientation = OrientationRequested.LANDSCAPE;
            courtWidth = (int) Math.min(this.getWidth() * 0.9, this.getHeight() * 1.8);
            courtHeight = (int) (courtWidth / 2.0);

        }

        center.x = (int) (getWidth() / 2.0);
        center.y = (int) (getHeight() / 2.0);

        left = (int) (center.x - courtWidth / 2.0);
        top = (int) (center.y - courtHeight / 2.0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        calcDimensions();

        drawFloor(g);
        drawLines(g);
    }

    private void drawFloor(Graphics g) {
        g.setColor(floorColor);
        g.fillRect(left, top, courtWidth, courtHeight);
    }

    private void drawLines(Graphics g) {
        if (orientation == OrientationRequested.PORTRAIT) {
            drawLines_Portrait(g);
        } else {
            drawLines_Landscape(g);
        }
    }

    private void drawLines_Portrait(Graphics g) {
        g.setColor(lineColor);

        // perimeter
        g.drawRect(left, top, courtWidth, courtHeight);

        // center line
        g.drawLine(left, center.y, left + courtWidth, center.y);

        // local attack line
        g.drawLine(left, center.y + courtHeight / 6, left + courtWidth, center.y + courtHeight / 6);

        // visitor attack line
        g.drawLine(left, center.y - courtHeight / 6, left + courtWidth, center.y - courtHeight / 6);
    }

    private void drawLines_Landscape(Graphics g) {
        g.setColor(lineColor);

        // perimeter
        g.drawRect(left, top, courtWidth, courtHeight);

        // center line
        g.drawLine(center.x, top, center.x, top + courtHeight);

        // local attack line
        g.drawLine(center.x - courtWidth / 6, top, center.x - courtWidth / 6, top + courtHeight);

        // visitor attack line
        g.drawLine(center.x + courtWidth / 6, top, center.x + courtWidth / 6, top + courtHeight);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new CourtCanvas());
                frame.setSize(500, 400);
                frame.setVisible(true);
            }
        });
    }
}