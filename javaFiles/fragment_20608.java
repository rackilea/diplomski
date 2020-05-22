import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.Border;

public class trial {

    public static void main(String args[]) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout(FlowLayout.LEFT));
        content.setBackground(Color.BLACK);
        tile t1 = new tile(new String[]{"arc", "curve", "curve"}, new Color[]{Color.GREEN, Color.RED, Color.YELLOW});
        content.add(t1);
        content.add(new gridModel((0.7 * 1000) / 21));

        window.add(content);
        window.pack();
        window.setVisible(true);
    }
}

class tile extends JPanel implements MouseListener {

    private String[] tilePaths = new String[3];
    private Color[] tileColors = new Color[3];
    private int x = 100, y = 100;

    public tile(String[] paths, Color[] colors) {
        tilePaths = paths;
        tileColors = colors;
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage tileImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D tile = tileImage.createGraphics();

        int edgeLength = tileImage.getWidth() / 2;
        Polygon hexagon = new Polygon();
        Point[] vertex = new Point[6];
        for (int i = 0; i < 6; i++) {
            vertex[i] = new Point((int) (edgeLength + edgeLength * Math.cos(i * 2 * Math.PI / 6)), (int) (edgeLength + edgeLength * Math.sin(i * 2 * Math.PI / 6)));
            hexagon.addPoint(vertex[i].x, vertex[i].y);
        }

        tile.setColor(Color.black);
        tile.fillPolygon(hexagon);
        tile.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN));
        tile.setStroke(new BasicStroke(10));

        int vertexIndex = 0;
        for (int i = 0; i < 3; i++) {
            if (tilePaths[i] == "arc") {
                Arc2D.Double arc = new Arc2D.Double();
                arc.setArcByCenter(vertex[vertexIndex].x, vertex[vertexIndex].y, edgeLength / 2, 0, 360, Arc2D.OPEN);
                tile.setColor(tileColors[i]);
                tile.draw(arc);
                vertexIndex++;
            } else if (tilePaths[i] == "curve") {
                Point midPoint1 = new Point((vertex[vertexIndex].x + vertex[vertexIndex + 1].x) / 2, (vertex[vertexIndex].y + vertex[vertexIndex + 1].y) / 2);
                Point midPoint2 = new Point((vertex[vertexIndex + 2].x + vertex[vertexIndex + 3].x) / 2, (vertex[vertexIndex + 2].y + vertex[vertexIndex + 3].y) / 2);
                tile.setColor(tileColors[i]);
                tile.draw(new QuadCurve2D.Float(midPoint1.x, midPoint1.y, edgeLength, edgeLength, midPoint2.x, midPoint2.y));
                vertexIndex++;
            } else {
                Point midPoint1 = new Point((vertex[vertexIndex].x + vertex[vertexIndex + 1].x) / 2, (vertex[vertexIndex].y + vertex[vertexIndex + 1].y) / 2);
                Point midPoint2 = new Point((vertex[vertexIndex + 3].x + vertex[vertexIndex + 4].x) / 2, (vertex[vertexIndex + 3].y + vertex[vertexIndex + 4].y) / 2);
                tile.setColor(tileColors[i]);
                tile.draw(new Line2D.Float(midPoint1.x, midPoint1.y, midPoint2.x, midPoint2.y));
                vertexIndex++;
            }
        }

        Graphics2D finishedTile = (Graphics2D) g;
        Border border = BorderFactory.createLineBorder(Color.BLUE);
        finishedTile.drawImage(tileImage, x, y, null);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // TODO Auto-generated method stub
        System.out.println("Click");
        x = event.getX();
        y = event.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // TODO Auto-generated method stub
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // TODO Auto-generated method stub
        System.out.println("Exited");
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // TODO Auto-generated method stub
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // TODO Auto-generated method stub
        System.out.println("Released");
    }

    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(2*x, 2*y);
    }
}

class gridModel extends JPanel {

    private double sideLength;

    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(2*(int)sideLength, 2*(int)sideLength);
    }

    public gridModel(double hexagonSide) {
        sideLength = hexagonSide;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        double fromLeft = 0, fromTop = sideLength;

        for (int i = 0; i < 14; i++) {
            if (i % 2 == 0) {
                fromLeft = sideLength;
            } else {
                fromLeft = (2.5) * sideLength;
            }

            for (int j = 0; j < 7; j++) {
                Polygon hexagon = buildHexagon(fromLeft, fromTop);
                g2.setColor(Color.green);
                g2.drawPolygon(hexagon);
                fromLeft += 3 * sideLength;
            }

            fromTop += 0.865 * sideLength;
        }
    }

    private Polygon buildHexagon(double leftMargin, double topMargin) {
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
            hexagon.addPoint((int) (leftMargin + sideLength * Math.cos(i * 2 * Math.PI / 6)), (int) (topMargin + sideLength * Math.sin(i * 2 * Math.PI / 6)));
        }
        return hexagon;
    }
}