import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class frame extends JFrame
{
JTextField txt;

frame()
{
    txt = new JTextField("Text goes here");
    txt.setBackground(Color.black);
    txt.setFont(new Font("verdana", Font.BOLD, 30));
    txt.setForeground(Color.white);
    add(txt);

    setVisible(true);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] arg)
{
    new frame();
}

}