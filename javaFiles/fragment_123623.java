import java.awt.EventQueue;
import javax.swing.JFrame;

public class FrameWithAnimatedIcon extends JFrame
{
public static void main(String[] args)
{
    final FrameWithAnimatedIcon frame = new FrameWithAnimatedIcon();
    EventQueue.invokeLater(new Runnable()
    {
        public void run()
        {
            try
            {
                frame.setVisible(true);
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    });

    IconAnimator animator = new IconAnimator(frame, Images.images, 250);
    animator.run();
}

public FrameWithAnimatedIcon()
{
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);

}
}