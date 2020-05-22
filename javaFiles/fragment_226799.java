package SimpleCRUD;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CRUDFrame extends JFrame {

// now it's not in constructor
JButton button1, button2, button3, button4;

public CRUDFrame(){
    super("AppCRUD");
    setLayout(new GridLayout(0,1,4,15));
    //setTitle("Hello");
    JLabel label1;

    label1 = new JLabel(" Telephone Book" , JLabel.CENTER);
    label1.setFont (new Font("fallan", 1, 25));
    label1.setToolTipText("What?");
    button1 = new JButton(" Show Contacts ");
    button2 = new JButton(" Add Contact ");
    button3 = new JButton(" Update Number in a Contact ");
    button4 = new JButton(" Delete a Contact ");

    add(label1);
    add(button1);   
    add(button2);  
    add(button3); 
    add(button4);
    ButtonListener onClick = new ButtonListener();
    button1.addActionListener(onClick);
    button2.addActionListener(onClick);
    button3.addActionListener(onClick);
    button4.addActionListener(onClick);

}


class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(CRUDFrame.this, e.getActionCommand(), "Event fired", JOptionPane.PLAIN_MESSAGE);
        if(e.getSource() == button1)
        System.out.println("HI!");  
    }
}

}