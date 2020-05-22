import java.awt.*;
import javax.swing.*;

public class TempProject
{
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Box mainContent = Box.createVerticalBox();
                mainContent.add(TempProject.getLabel("abc"));
                mainContent.add(TempProject.getLabel("Longer"));
                mainContent.add(TempProject.getLabel("Longerest"));
                mainContent.add(TempProject.getLabel("Smaller"));

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setContentPane(mainContent);    
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static JLabel getLabel(String text){
        JLabel c = new JLabel(text);
        c.setHorizontalTextPosition(SwingConstants.LEADING);
        c.setAlignmentX(SwingConstants.RIGHT);
        c.setIcon(UIManager.getIcon("FileChooser.detailsViewIcon"));
        return c;
    }
}