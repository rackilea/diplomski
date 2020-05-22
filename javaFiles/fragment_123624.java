import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JFrame;

public class IconAnimator
{

JFrame           frame = null;
ArrayList<Image> images;
long             msBetweenImages;

public IconAnimator(JFrame frame, ArrayList<Image> images, long msBetweenImages)
{
    this.frame = frame;
    this.images = images;
    this.msBetweenImages = msBetweenImages;
}

public void run()
{
    while(true)
    {
        for(Image image : images)
        {
            try
            {
                frame.setIconImage(image);

                Thread.sleep(msBetweenImages);

            } catch(InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if(frame == null)
            {
                return;
            }
        }
    }
}
}