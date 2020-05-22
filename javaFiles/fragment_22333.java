import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyFrame extends JFrame{
    JButton button;
    private static MyFrame frame;
    public MyFrame(){
        this.setSize(400, 400);
        this.setLayout(new CardLayout());
        this.setLocationRelativeTo(null);
        JPanel dp1 = new JPanel();
        dp1.setBackground(Color.RED);
        add(dp1);
        button  = new JButton("Click me to remove dp1 & draw dp2");
        dp1.add (button);
        JPanel dp2 = new JPanel ();
        dp2.setBackground(Color.GREEN);


        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.getContentPane().remove(dp1);
                frame.add(dp2);
                frame.revalidate();
                frame.repaint();

            }});

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible (true);
    }

    public static void main(String[] args) {
        frame = new MyFrame();
    }
}