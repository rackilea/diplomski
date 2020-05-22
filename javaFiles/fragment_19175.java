import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class main
{
    public static void main(String[] args)
    {
        JFrame mainWindow = new JFrame("8 Game");
        mainWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(200, 200);
        JButton eightButton = new JButton("8");
        eightButton.setText("8");
        eightButton.setSize(30, 30);
        eightButton.setBounds(5, 5, 25, 25);
        //eightButton.setAction(new buttonAction());
        //eightButton.setContentAreaFilled(false);


        mainWindow.add(eightButton);
        mainWindow.setVisible(true);
    }
}