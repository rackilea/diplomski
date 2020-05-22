import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class testText {
    public static void main(String[] args){

        JFrame frame = new JFrame();
        final JTextField text = new JTextField();
        frame.add(text);
        frame.setVisible(true);

        text.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(text.getText());
            }
        });
    }
}