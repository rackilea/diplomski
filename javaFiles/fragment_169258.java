import javax.swing.*;
import java.awt.event.*;

public class Viewer {
    private static JButton b1 = new JButton("Action Listener");
    private static JFrame f = new JFrame();
    private static JPanel p = new JPanel();
    private static int location = 100; //Make a variable for location
    public static void main(String[]args){
        f.setVisible(true);
        f.setSize(400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        p.add(b1);
        f.add(p);       
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {        
                b1.setLocation(location,100);
                location += 10; //This will change where it draws next time
            }
        });
    }
}