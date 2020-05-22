import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {

    public static void main(final String[] args) {
        final JFrame frame = new JFrame();
        final JButton button = new JButton("Print");
        final JTextField field = new JTextField();
        frame.setLayout(new BorderLayout());
        frame.add(button, BorderLayout.NORTH);
        frame.add(field, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.pack();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(field.getText());
            }
        });
    }

}