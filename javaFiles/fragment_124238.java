import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Test extends JFrame {

    private Triangle triangle;
    private final int step = 10;
    private Triangle keyboardPanel = new Triangle();

    public static void main(String[] args) {
        Test t = new Test();

    }

    public Test() {

        setTitle("TRY TRY TRY");
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);

        JPanel tripanel = new move();

        add(tripanel);

        triangle = new Triangle();

        setVisible(true);
    }

    class move extends JPanel implements MouseListener, MouseMotionListener {

        private int x = 210;
        private int y = 210;
        private Color color = Color.BLACK;

        move() {

            addMouseListener(move.this);
            addMouseMotionListener(move.this);

            this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "moveright");
            this.getActionMap().put("moveright", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    triangle.moveTriangle(10, 0);
                    repaint();
                }
            });

        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("hello");
            x = e.getX();
            y = e.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            x = e.getX();
            y = e.getY();
            System.out.println("hello123");
            if (e.isControlDown()) {
                color = Color.RED;
            } else {
                color = Color.BLACK;
            }
            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            //System.out.println(e.getPoint());
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            triangle.drawTriangle(g);
        }

    }

    class Triangle {

        private Point p1;
        private Point p2;
        private Point p3;

        int numX;
        int numY;

        public Triangle() {

            p1 = new Point(200, 200);
            p2 = new Point(170, 230);
            p3 = new Point(230, 230);
        }

        public void moveTriangle(int dx, int dy) {
            p1.move(dx, dy);
            p2.move(dx, dy);
            p3.move(dx, dy);

        }

        public void drawTriangle(Graphics g) {
            g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            g.drawLine(p2.getX(), p2.getY(), p3.getX(), p3.getY());
            g.drawLine(p3.getX(), p3.getY(), p1.getX(), p1.getY());
        }
    }

    class Point {

        private int x;
        private int y;

        public Point(int X, int Y) {
            x = X;
            y = Y;
        }

        public void setX(int X) {
            x = X;
        }

        public void setY(int Y) {
            x = Y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void move(int dx, int dy) {
            x += dx;
            y += dy;
        }

        public String toString() {
            return ("X = " + x + " Y= " + y);
        }
    }
}