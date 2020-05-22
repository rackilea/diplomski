import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 

public class PositiveOrNegative extends JFrame {

    JLabel l1, l2 ;
    JTextField t1, t2 ;

    public PositiveOrNegative() {
        FlowLayout layout = new FlowLayout(); 

        this.setLayout(layout); 

        l1 = new JLabel("Enter a number "); 
        t1 = new JTextField(10);
        l2 = new JLabel("The number is  ");
        t2 = new JTextField(10);

        this.add(l1); 
        this.add(t1);
        this.add(l2);
        this.add(t2);
        t2.setEditable(false);
        t2.setBackground(Color.PINK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = t1.getText();
                try {
                    int number = Integer.parseInt(n);

                    if (number >= 0)
                        t2.setText("POSITIVE");
                    else
                        t2.setText("NEGATIVE");
                } catch (Exception ex) {
                    t2.setText("Not an integer");
                }
            }
        });
    }

    public static void main(String[] args) { 
        PositiveOrNegative p = new PositiveOrNegative(); 
        p.setTitle("AWT SIGN"); 
        p.setBounds(300, 300, 300, 120); 
        p.setVisible(true); 
    } 

}