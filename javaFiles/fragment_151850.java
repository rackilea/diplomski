import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;

public class Test {

    private MyPanel p;
    private Timer t;

    public Test() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        frame.add(p);

        frame.pack();
        frame.setVisible(true);

        t.start();
    }

    private void initComponents() {
        final ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                p.moveEntities();//moves ball etc
                p.repaint();
            }
        };

        t = new Timer(50, action);
        p = new MyPanel();

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                p.addEntity(e.getX(), e.getY(), 10, 50, Color.GREEN);
                System.out.println("clicked");
            }
        });

        p.setBackground(Color.WHITE);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}

class MyPanel extends JPanel {

    int width = 300, height = 300;
    ArrayList<MyRectangle> entities = new ArrayList<>();
    MyBall ball = new MyBall(10, 10, 25, 25, Color.RED, width, height);

    void addEntity(int x, int y, int w, int h, Color c) {
        entities.add(new MyRectangle(x, y, w, h, c));
    }

    void moveEntities() {
        ball.moveBALL();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(ball.getColor());
        g2d.fillOval((int) ball.x, (int) ball.y, (int) ball.width, (int) ball.height);

        for (MyRectangle entity : entities) {
            g2d.setColor(entity.getColor());
            g2d.fillRect((int) entity.x, (int) entity.y, (int) entity.width, (int) entity.height);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}

class MyRectangle extends Rectangle2D.Double {

    Color color;

    public MyRectangle(double x, double y, double w, double h, Color c) {
        super(x, y, w, h);
        color = c;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

class MyBall extends Ellipse2D.Double {

    int xspeed = 1;
    int yspeed = 1;
    Color color;
    private final int maxWidth;
    private final int maxHeight;

    public MyBall(double x, double y, double w, double h, Color c, int maxWidth, int maxHeight) {
        super(x, y, w, h);
        color = c;
        this.width = w;//set width and height of Rectangle2D
        this.height = h;
        //set max width and height ball can move
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    void moveBALL() {
        x = x + xspeed;
        y = y + yspeed;
        if (x < 0) {
            x = 0;
            xspeed = -xspeed;
        } else if (x > maxWidth - ((int) getWidth() / 2)) {// i dont like hard coding values its not good oractice and resuaibilty is diminshed
            x = maxWidth - ((int) getWidth() / 2);
            xspeed = -xspeed;
        }
        if (y < 0) {
            y = 0;
            yspeed = -yspeed;
        } else if (y > maxHeight - ((int) getHeight() / 2)) {
            y = maxHeight - ((int) getHeight() / 2);
            yspeed = -yspeed;
        }
    }
}