import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dialog extends JDialog implements ActionListener{

    public Dialog(Generator g){
        setSize(300, 300);
        JButton b = new JButton("click me");
        b.addActionListener(g);
        add(b);
        setVisible(true);
    } 
}