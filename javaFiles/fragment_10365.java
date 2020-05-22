import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.util.Deque;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Doiles());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Doiles extends JPanel implements MouseListener, ActionListener, MouseMotionListener {
        //global variable declarations

        int nlines = 12;//store the number of sector defining lines
        int currentovalsize = 10;
        Color currentcolour = Color.WHITE;
        Deque<DoilyPoint> points = new LinkedList<DoilyPoint>();

        Color test[] = {Color.RED,
                                        Color.GREEN,
                                        Color.BLUE, Color.MAGENTA, Color.CYAN};

        public Doiles() {

            //drawing panel + paint method
            JPanel drawingPanel = new JPanel() {
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    int lineLength = Math.max(getWidth(), getHeight());
                    Point centerPoint = new Point(getWidth() / 2, getHeight() / 2);

                    //calculate angle between sectors
                    double theta = Math.toRadians(360.0 / nlines);
                    g.setColor(Color.WHITE);

                    //calculate line coordinates and draw the sector lines
                    for (int i = 0; i < nlines; i++) {
                        g.drawLine(centerPoint.x, centerPoint.y,
                                             centerPoint.x + (int) Math.round(lineLength * Math.cos(theta * i)),
                                             centerPoint.y + (int) Math.round(lineLength * Math.sin(theta * i)));
                    }
                    double delta = 360.0 / (double) nlines;
                    Graphics2D gCopy = (Graphics2D) g.create();
                    AffineTransform at = AffineTransform.getRotateInstance(
                            Math.toRadians(delta),
                            centerPoint.x,
                            centerPoint.x);
                    for (int h = 0; h < nlines; h++) {
                        for (DoilyPoint j : points) {
                            gCopy.fillOval(j.getX(), j.getY(), j.getSize(), j.getSize());
                        }
                        gCopy.transform(at);
                    }
                    gCopy.dispose();
                }
            };
            drawingPanel.setBackground(Color.BLACK);
            drawingPanel.addMouseMotionListener(this);
            drawingPanel.addMouseListener(this);
            setLayout(new BorderLayout());
            add(drawingPanel);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        public void addPoint(int x, int y) {
            points.addFirst(new DoilyPoint(currentovalsize, x, y, currentcolour));
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            addPoint(e.getX(), e.getY());
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//          addPoint(e.getX(), e.getY());
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    class DoilyPoint {

        private int size;
        private int x;
        private int y;
        private Color colour;

        void setSize(int a) {
            this.size = a;
        }

        int getSize() {
            return size;
        }

        void setX(int a) {
            this.x = a;
        }

        int getX() {
            return x;
        }

        void setY(int a) {
            this.y = a;
        }

        int getY() {
            return y;
        }

        void setColor(Color r) {
            this.colour = r;
        }

        Color getColor() {
            return colour;
        }

        public DoilyPoint(int size, int x, int y, Color colour) {
            this.size = size;
            this.x = x;
            this.y = y;
            this.colour = colour;
        }
    }
}