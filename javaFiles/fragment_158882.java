package test;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Window extends JPanel
{
    public Window(ActionListener listener)
    {
        JButton b = new JButton("Button 1");
        b.addActionListener(listener);
        add(b);

        //do other stuff
    }
    public static void main(String[] args)
    {
        Window w = new Window(new Main());
        //continue with initialization process
    }
}