import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Font1  {
public static void main(String Args[])
{
JFrame frame=new JFrame();
frame.setBounds(100, 100, 450, 300);
    JLabel string1=new JLabel("Some Text");
    string1.setBounds(100,100,450,300);
    JTextField txt=new JTextField("add");
    string1.setFont (new Font("Arial", Font.BOLD, 22));
    frame.setVisible(true);
    frame.add(string1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}