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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test extends JPanel {

    public static void main(String[] args) {
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
                frame.add(new Test());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static final long serialVersionUID = -7762339485544442517L;
    private final int SIZE = 10;
    private ArrayList<MovableObject> pointList;
    private int move;
    private final int Delay = 50, WIDTH = 500, HEIGHT = 400;

    Random count = new Random();
    private Timer timer = null;
//--------------------------------------------------------------------------        --------------------------------------------------------------------------------------------------------//

    public Test() {
        timer = new Timer(Delay, new ActListener());
        pointList = new ArrayList<MovableObject>();
        //x =0;
        //y =50;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addMouseListener(new DotsListener());
        timer.start();
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int R = (int) (Math.random() * 256); //randomizes colors
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        Color randomColor = new Color(R, G, B);
        //randomize color of the rectangles//
        g2d.setColor(randomColor);
        for (MovableObject spot : pointList) {
            spot.paint(g2d);
        }
        g2d.drawString("Count: " + pointList.size(), 10, 15);
        g2d.dispose();
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    private class DotsListener implements MouseListener {

        public void mousePressed(MouseEvent event) {
        }

        public void mouseClicked(MouseEvent event) {
            pointList.add(new MovableObject(new Point(event.getPoint()), new Point(count.nextInt(10) + 1, count.nextInt(10) + 1)));
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
        }

        public void mouseExited(MouseEvent event) {
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    private class ActListener implements ActionListener {
        //-------------------------------------------------------------
        //  Updates the position of the image and possibly the direction
        //  of movement whenever the timer fires an action event.
        //-------------------------------------------------------------

        public void actionPerformed(ActionEvent event) {
            for (MovableObject obj : pointList) {
                obj.move(getSize());
            }
            repaint();
        }
    }

    public class MovableObject {

        private Point point;
        private Point vector;

        public MovableObject(Point point, Point vector) {
            this.point = point;
            this.vector = vector;
        }

        public void paint(Graphics2D g2d) {
            g2d.fillRect(point.x - SIZE, point.y - SIZE, SIZE * 2, SIZE * 2);
        }

        public void move(Dimension bounds) {
            point.x += vector.x;
            point.y += vector.y;
            if (point.x - SIZE <= 0) {
                vector.x *= -1;
                point.x = 0;
            } else if (point.x + SIZE > bounds.width) {
                vector.x *= -1;
                point.x = bounds.width - SIZE;
            }
            if (point.y - SIZE <= 0) {
                vector.y *= -1;
                point.y = 0;
            } else if (point.y + SIZE >= bounds.width) {
                vector.y *= -1;
                point.y = bounds.height - SIZE;
            }
        }

    }
}