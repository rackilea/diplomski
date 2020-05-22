import java.awt.geom.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class ScreenCapturer
{
    public static void main(String[] args)throws Exception
    {
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(resolution);
        Robot robot = new Robot();
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        Graphics g = bufferedImage.getGraphics();
        //g.drawImage(bufferedImage.getScaledInstance(bufferedImage.getWidth(), bufferedImage.getHeight(), Image.SCALE_DEFAULT), 0, 0, null);
        File out = new File("image.png");
        ImageIO.write(bufferedImage,"png",out);
    }
}