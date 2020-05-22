import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SwingTest extends JFrame {

    private static final int SIZE = 300;
    private DrawPoint drawPoint;

    public SwingTest()  {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        drawPoint = new DrawPoint();
        drawPoint.setPreferredSize(new Dimension(SIZE, SIZE));
        add(drawPoint);
        pack();
        setVisible(true);
    }

    //demonstrate change in DrawPoint state
    private void reDraw() {

        Random rnd = new Random();
        Timer timer = new Timer(1000, e -> { //periodically change coordinates and repaint
            drawPoint.setCoordx(rnd.nextInt(SIZE));
            drawPoint.setCoordy(rnd.nextInt(SIZE));
            drawPoint.repaint();
        });
        timer.start();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->    new SwingTest().reDraw());
    }
}

class DrawPoint extends JPanel {

    private int coordx, coordy;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(coordx,coordy,8,8);
    }

    //use setters to change the state 
    void setCoordy(int coordy) {    this.coordy = coordy; }
    void setCoordx(int coordx) {this.coordx = coordx;}
}