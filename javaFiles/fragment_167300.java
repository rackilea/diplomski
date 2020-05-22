import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MainFoo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }

    private static void createAndShowGui() {
        DrawBoard mainPanel = new DrawBoard();
        JFrame frame = new JFrame("Main Foo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

// DrawBoard should start with a capital letter
class DrawBoard extends JPanel {
    private static final int PREF_W = 1000;
    private static final int PREF_H = 600;
    int n = 0;
    List<MyPoint> myPoints = new ArrayList<>();

    public DrawBoard() {
        MyMouseAdapter ma = new MyMouseAdapter(this);
        this.addMouseListener(ma);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        } else {
            return new Dimension(PREF_W, PREF_H);
        }
    }

    public void addMyPoint(Point p) {
        MyPoint myPoint = new MyPoint(p);
        myPoints.add(myPoint);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, 600, 500);

        // use Graphics2D to allow for smoothing
        Graphics2D g2 = (Graphics2D) g;

        // smooth with rendering hiints
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // iterate through each MyPoint in the list
        for (MyPoint myPoint : myPoints) {
            myPoint.draw(g2); // and draw it
        }

    }

}

class MyMouseAdapter extends MouseAdapter {
    DrawBoard owner;

    public MyMouseAdapter(DrawBoard owner) {
        this.owner = owner;
    }

    // btetter to use mousePressed, not mouseClicked
    @Override
    public void mousePressed(MouseEvent b) {
        owner.addMyPoint(b.getPoint());
    }
}

class MyPoint {
    public int x;
    public int y;

    public MyPoint(Point p) {
        x = (int) p.getX();
        y = (int) p.getY();
    }

    public void draw(Graphics2D g2) {
        g2.drawOval(x - 3, y - 3, 6, 6);
    }
}