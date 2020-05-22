import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ckbxdm{
    JFrame frame;
    JRadioButton r1,r2;
    ButtonGroup grp;
    JLabel l1,l2;

    void box(){
        frame=new JFrame("Hello");
        r1=new JRadioButton("Login");
        r2=new JRadioButton("Signup");
        grp=new ButtonGroup();
        grp.add(r1);
        grp.add(r2);

        l1=new JLabel("Login area");
        l1.setBounds(100,200,100,20);
        l1.setVisible(false);
        frame.getContentPane().add(l1);

        l2=new JLabel("Signup area");
        l2.setBounds(100,200,100,20);
        l2.setVisible(false);
        frame.getContentPane().add(l2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().add(r1);
        frame.getContentPane().add(r2);
        r1.setBounds(100,120,100,20);
        r2.setBounds(200,120,100,20);
        frame.setBounds(100,100,500,500);
        frame.setVisible(true);
        r1.addActionListener(new listener1());
        r2.addActionListener(new listener2());
    }
    class listener1 implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            l2.setVisible(false);
            l1.setVisible(true);
            frame.getContentPane().repaint();

        }
    }
    class listener2 implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            l1.setVisible(false);
            l2.setVisible(true);
            frame.getContentPane().repaint();
        }
    }
    public void itemStateChanged(ItemEvent ie){
        frame.repaint();
    }
}
public class CheckboxDemo{
    public static void main(String args[]){
        ckbxdm obj=new ckbxdm();
        obj.box();
    }
}