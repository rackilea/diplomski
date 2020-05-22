import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame
{
    private JFrame window = new JFrame();
    private JButton but[] = new JButton[9];

    public Gui()
    {
        window.setSize(300,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setLayout(new GridLayout(4, 3));
        JPanel panel = new JPanel( new GridLayout(3, 3) );
        window.add(panel, BorderLayout.CENTER);

        JLabel txt = new JLabel("Will you dare?", JLabel.CENTER);
//        txt.setLayout(new GridLayout(1, 1));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setFont(new Font("Serif", Font.PLAIN, 21));
//        window.add(txt);
        window.add(txt, BorderLayout.NORTH);

        for(int i = 0; i < 9; i++)
        {
            but[i] = new JButton();
//            window.add(but[i]);
            panel.add(but[i]);
        }

        window.setVisible(true);

    }

    public static void main(String args[]) throws Exception
    {
        new Gui();
    }

}