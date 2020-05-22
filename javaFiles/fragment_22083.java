import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MoveShape extends JPanel {

    List<Shape> shapes;

    public MoveShape() {
        shapes = createShapeList();

        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        ActionMap am = getActionMap();
        am.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Shape sh : shapes) {
                    sh.moveRight();
                    repaint();
                }
            }
        });
    }

    private List<Shape> createShapeList() {
        List<Shape> list = new ArrayList<>();
        int xPoly[] = {75, 125, 170, 170, 200, 105, 60};
        int yPoly[] = {75, 50, 88, 111, 125, 180, 150};
        list.add(new MyPolygon(xPoly, yPoly, 6));
        list.add(new MyRectangle(75, 250, 150, 150));
        return list;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape sh : shapes) {
            sh.drawShape(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(450, 450);
    }

    public class MyRectangle implements Shape {

        int x, y, width, height;

        public MyRectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void drawShape(Graphics g) {
            g.fillRect(x, y, width, height);
        }

        @Override
        public void moveRight() {
            x += INCREMENT;
        }

    }

    public class MyPolygon implements Shape {

        int[] xPoints;
        int[] yPoints;
        int numPoints;

        public MyPolygon(int[] xPoints, int[] yPoints, int numPoints) {
            this.xPoints = xPoints;
            this.yPoints = yPoints;
            this.numPoints = numPoints;
        }

        @Override
        public void drawShape(Graphics g) {
            g.fillPolygon(xPoints, yPoints, numPoints);
        }

        @Override
        public void moveRight() {
            for (int i = 0; i < xPoints.length; i++) {

                xPoints[i] += INCREMENT;

            }  
        }
    }

    public interface Shape {

        public static final int INCREMENT = 5;

        public void drawShape(Graphics g);

        public void moveRight();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Move Shapes");
                frame.add(new MoveShape());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}