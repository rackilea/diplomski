import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ExamplePanel extends JPanel implements ActionListener{
JButton btn, btn2;
    public ExamplePanel1(String title) {
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createTitledBorder(title));
        btn = new JButton("Ok");
        btn2= new JButton("Cancel");
        setLayout(new FlowLayout());
        add(btn);
        add(btn2);
        btn.addActionListener(this);
        btn2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==btn){
        JOptionPane.showMessageDialog(null, "Hi");
        }

        if(e.getSource()==btn2){
        JOptionPane.showConfirmDialog(null, "Hi there");
        }
    }
}