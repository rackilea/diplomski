import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingBall extends JPanel {

    private int ballX = 30;
    private int ballY = 30;

    public MovingBall() {
        setBackground(Color.BLACK);
    }

    public MovingBall(int x, int y) {
        x = this.ballX;
        y = this.ballY;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);

        MovingBall movingBall = new MovingBall();
        frame.add(movingBall);
        frame.setVisible(true);

        BallUsingTimer ball = new BallUsingTimer(movingBall);
        Timer timer = new Timer(40, ball);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);

        canvas.setColor(Color.BLUE);
        canvas.fillOval(ballX, ballY, 100, 100);
    }

    public void updateBall() {
        ballX++;
        repaint();
    }

}