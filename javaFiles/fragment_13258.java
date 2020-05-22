import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ImageWorker implements KeyListener
{
    private JLabel imageLabel;
    private ImageIcon basicImage;
    private ImageIcon whiteImage;
    private boolean isBasic =  true;
    private int delay = 1000; //milliseconds
    private Timer timer;

    public static void main(String[] args)
    {
        new ImageWorker();
    }

    public ImageWorker()
    {
        final JFrame frame = new JFrame();
        imageLabel = new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.getContentPane().add(imageLabel);
        frame.setVisible(true);

        try
        {
            basicImage = new ImageIcon(ImageIO.read(new File("src\\img\\basis1.jpg")).getScaledInstance(1024, 768, Image.SCALE_SMOOTH));
            whiteImage = new ImageIcon(ImageIO.read(new File("src\\img\\wit.jpg")).getScaledInstance(1024, 768, Image.SCALE_SMOOTH));       
        }
        catch (IOException ex)
        {
            ex.getMessage();
            ex.printStackTrace();
        }

        frame.addKeyListener(this);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(isBasic) {
                    //display basic image
                    imageLabel.setIcon(basicImage);
                }
                else {
                    //display white image
                    imageLabel.setIcon(whiteImage);
                }

                //toggle the flag
                isBasic = !isBasic;
            }
        };
        //use a timer instead of SwingWorker
        timer = new Timer(delay, taskPerformer);
        timer.start();

    }



    @Override
    public void keyPressed(KeyEvent e)
    {
        //key pressed, we want to stop toggling so stop the timer
        timer.stop();
        //do whatever else you were doing to set the value for isCancelled();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }
}