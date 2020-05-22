import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldExample extends GraphicsProgram {

    @Override
    public void init() {
        nameField = new JTextField(15);
        add(new JLabel("Name: "), NORTH);
        add(nameField, NORTH);
        nameField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nameField) {
            println("Hello, " + nameField.getText());
        }
    }
    private JTextField nameField;
}