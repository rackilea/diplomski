package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class combodemo implements ActionListener
{
JFrame f;
JPanel p;
JTextField tf;
JButton b1;
JButton b2;
JRadioButton rb1;
JRadioButton rb2;
JLabel l;
JComboBox cb;
JCheckBox c1,c2,c3;
ButtonGroup bg;

combodemo()
{
String  []h = {"red","yellow","green"};
cb = new JComboBox(h);
f = new JFrame();
p = new JPanel();
tf = new JTextField(30);
b1 = new JButton("OK");
b2 = new JButton("Clear");
rb1 = new JRadioButton("male");
rb2 = new JRadioButton("Female");
l = new JLabel("Enter Text");
c1 = new JCheckBox("java");
c2 = new JCheckBox("C++");
c3 = new JCheckBox("Microsoft");
bg = new ButtonGroup();

f.add(p);
p.add(l);
p.add(tf);
b1.addActionListener(this);
b2.addActionListener(this);
cb.addActionListener(this);
p.add(b1);
p.add(b2);
bg.add(rb1);
bg.add(rb2);
p.add(rb1);
p.add(rb2);
p.add(cb);
p.add(c1);
p.add(c2);
p.add(c3);

f.setVisible(true);
f.pack();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent ae)

{
    if(ae.getSource() instanceof JComboBox) {
        String str = (String)cb.getSelectedItem();
        if(str.equals("red"))
        p.setBackground(Color.red);

        if(str.equals("green"))
        p.setBackground(Color.green);

        if(str.equals("yellow"))
        p.setBackground(Color.yellow);
    }


if(ae.getActionCommand()=="OK")
{
tf.setText("This is example of swing");
}
if(ae.getActionCommand()=="Clear")
{
tf.setText("");
}
}
public static void main (String [] args)

{
combodemo cd = new combodemo();
} 
}