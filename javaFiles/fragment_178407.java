import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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

        BallUsingThread ball = new BallUsingThread(movingBall);
        Thread first = new Thread(ball);
        first.start();

    }

    @Override
    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);

        canvas.setColor(Color.BLUE);
        canvas.fillOval(ballX, ballY, 100, 100);
    }

    public void updateBall() {
        if (EventQueue.isDispatchThread()) {
            ballX++;
            repaint();
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    updateBall();
                }
            });
        }
    }

}

/*Here is the second class. Where the oval shape should be moving. Any `suggestions here? Also just let me know if there are some codes need to be adjusted.*/
class BallUsingThread implements Runnable {

    private MovingBall movingBall;

    public BallUsingThread(MovingBall mb) {
        movingBall = mb;
    }

    @Override
    public void run() {
        for (;;) {
            movingBall.updateBall();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.printf("Error", ex);
            }
        }
    }

}