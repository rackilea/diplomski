import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;

public class SetJButtonTextColor
{
    public static void main(String[]args)
    {
        JButton button=new JButton();
        JFrame frame=new JFrame("Frame");
        frame.setLayout(new FlowLayout());
        button.setText("<html><span style=\"color:blue\">Click</span>   <span style=\"color:green\">Here</span></html>");
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,100);
        frame.setVisible(true);
    }
}