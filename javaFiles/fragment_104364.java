import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by matt on 11/30/15.
 */
public class BouncingBall {
    int width = 600;
    int height = 600;
    double diameter = 100;
    double v = 10;
    double vx = 6;
    double vy = 8;
    Ellipse2D ball = new Ellipse2D.Double(width/4, height/4, diameter, diameter);
    Ellipse2D post = new Ellipse2D.Double(width/2 - diameter, height/2 - diameter, 2*diameter, 2*diameter);

    JPanel display;
    void buildGui(){
        JFrame frame = new JFrame("ball");

        display = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D)g;

                g2d.setColor(Color.BLACK);
                g2d.fill(post);
                g2d.setColor(Color.RED);
                AffineTransform original = g2d.getTransform();
                for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                        AffineTransform wrapper = new AffineTransform(original);
                        wrapper.translate((i-1)*width, (j-1)*height);
                        g2d.setTransform(wrapper);
                        g2d.draw(ball);
                    }
                }
                g2d.setTransform(original);
            }
        };

        display.setMinimumSize(new Dimension(width, height));
        display.setPreferredSize(new Dimension(width, height));
        display.setMaximumSize(new Dimension(width, height));

        frame.setContentPane(display);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    void startSimulation(){
        while (!Thread.interrupted()&&display.isVisible()) {

            double x = ball.getX() + vx;
            double y = ball.getY() + vy;

            //wrap the ball around.
            if(x>width) x = x-width;
            if(x<0) x = x+width;
            if(y>height) y = y-height;
            if(y<0) y = y+height;

            ball.setFrame(x, y, diameter, diameter);

            //check for collision.

            double dx = ball.getCenterX() - 0.5*width;
            double dy = ball.getCenterY() - 0.5*height;

            double distance = Math.sqrt(dx*dx + dy*dy);
            if(distance < 1.5*diameter){
                vx = v*dx/distance;
                vy = v*dy/distance;
            }

            display.repaint();

            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
    public static void main(String[] args) throws Exception {
        BouncingBall b = new BouncingBall();
        EventQueue.invokeAndWait(b::buildGui);
        b.startSimulation();
    }

}