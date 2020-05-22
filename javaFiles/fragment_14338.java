import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Example extends JFrame {

    public Example() {
        JButton button = new JButton("btn");
        add(button,BorderLayout.WEST);
        JTextField field = new JTextField(5);
        field.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent arg0) {
                ((JTextField)arg0.getComponent()).setBorder(BorderFactory.createLineBorder(Color.RED));
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                ((JTextField)arg0.getComponent()).setBorder(null);
            }
        });

        add(field,BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        new Example();
    }
}