import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlideShow extends JPanel
{
    private int i = 0;
    private Timer timer;
    private JLabel images = new JLabel();
    private Icon bg = UIManager.getIcon("OptionPane.warningIcon");
    private Icon red = UIManager.getIcon("OptionPane.errorIcon");
    private Icon blue =  UIManager.getIcon("OptionPane.informationIcon");
    private ImageIcon pictures1, pictures2, pictures3, pictures4;
    private ActionListener action = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {           

            boolean go = true;

            i++;
            System.out.println(i);

            if(i == 1)
            {
                images.setIcon(bg);                                                                                                      
                System.out.println("picture 1 should be displayed here");
            }
            if(i == 2)
            {
                images.setIcon(red);   
                System.out.println("picture 2 should be displayed here");
            }
            if(i == 3)
            {
                images.setIcon(blue);   
                System.out.println("picture 3 should be displayed here");  
            }
            if(i == 4)
            {
                images.setIcon(bg);   
                System.out.println("picture 4 should be displayed here");  
            }
            if(i == 5)
            {
                go = false;
                timer.stop();
                System.exit(0);
            }
            revalidate();
            repaint();
        }
    };

    public SlideShow()
    {
        JFrame frame = new JFrame("SLIDE SHOW");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.getContentPane().add(this);

        add(images);

        frame.setSize(300, 300);
        frame.setVisible(true); 
        timer = new Timer(2000, action);    
        timer.start();  
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new SlideShow();
            }
        });
    }
}