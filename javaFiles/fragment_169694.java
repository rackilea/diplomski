import java.awt.Point;
import javax.swing.ImageIcon;
public class CharlesPaddle extends Paddle {
    /************************************************** ***************/
    public CharlesPaddle(int _x) {
        super(_x);
        ImageIcon iiPaddle = new ImageIcon(this.getClass().getResource("paddle.png"));
        paddleImage = iiPaddle.getImage();
    } 
    /************************************************** ***************/
   public void update() {
        goingUp = updateDirection(goingUp);
        if (goingUp)
            paddleLocation.y += 1;
        else
            paddleLocation.y -= 1;

        System.out.println("y position: " + paddleLocation.y);
    }

    /************************************************** ***************/
    public void init() {
        paddleLocation = new Point();
        paddleVector = new Point();
        paddleVector.x = 0;
        paddleVector.y = speed;
        paddleLocation.x = xLocation;
        paddleLocation.y = 200;
    } 
    /************************************************** ***************/
    public boolean updateDirection(boolean goingUp)    // This name makes more sense
    {
        if (goingUp && paddleLocation.y >= 465)      // It's just peaked,
            return false;                            // so return false (going down)
        else if (!goingUp && paddleLocation.y <= 20) // It's just gone to the bottom,
            return true;                             // so return true (going up)
        else                                         // It's somewhere in between,
            return goingUp;                          // so don't change anything!             
    }
}