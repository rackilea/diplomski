import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SorryPoolTable extends JPanel{

    List<ABall> balls = new ArrayList<ABall>();

    public SorryPoolTable(){
        makeBalls();
    }

    public void makeBalls(){
        balls.add(new ABall(213, 2, 255, true, 125, 25));
        balls.add(new ABall(65, 34, 25, true, 150, 135));
        balls.add(new ABall(124, 211, 45, true, 160, 180));
        balls.add(new ABall(35, 123, 255, true, 200, 200));
        balls.add(new ABall(45, 222, 255, true, 50, 200));
        balls.add(new ABall(65, 92, 155, true, 125, 175));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (ABall ball : balls) {
            ball.drawBall(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                JFrame frame = new JFrame("Sorry Pool Table");
                frame.add(new SorryPoolTable());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

class ABall {
    int R, G, B;
    boolean striped;
    int x, y;

    public ABall(int R, int G, int B, boolean striped, int x, int y) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.striped = striped;
        this.x = x;
        this.y = y;
    }

    public void drawBall(Graphics g) {
        g.setColor(new Color(R, G, B));
        g.fillOval(x, y, 20, 20);
    }
}