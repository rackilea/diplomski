import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        final JFrame f1=new JFrame();
        f1.setBounds(100,100,100,100);
        final Button b = new Button();
        b.setLabel("Test");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    f1.setVisible(!f1.isVisible());
                }
            }
        });
        f1.add(b);
        f1.setVisible(true);

    }
}