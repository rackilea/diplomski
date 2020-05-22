import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class test {
    public static void main(String[] arg)throws Exception
    {
        BufferedImage imgIn = ImageIO.read(new File("/home/arpit/Desktop/image.jpg"));
        BufferedImage imgIn2 =  new BufferedImage(imgIn.getHeight(), imgIn.getWidth(), imgIn.getType());

        for(int x=0;x<imgIn.getWidth();x++)
        {
            for(int y=0;y<imgIn.getHeight();y++)
            {
                int color = imgIn.getRGB(x,y);
                imgIn2.setRGB(imgIn2.getWidth()-1-y,x,color);

            }
        }
        ImageIO.write(imgIn2, "JPEG", new File("/home/arpit/Desktop/testrotated.jpg"));
    }
}