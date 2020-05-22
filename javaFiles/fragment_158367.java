import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Foo2 {
    public static void main(String[] args) {
        JPanel buttonContainer = new JPanel(new GridLayout(3, 9, 10, 10));
        List<JButton> letterButtons = new ArrayList<JButton>(); // *** may not even be necessary
        for (char buttonChar = 'A'; buttonChar <= 'Z'; buttonChar++) {
            String buttonText = String.valueOf(buttonChar);
            JButton letterButton = new JButton(buttonText);
            letterButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String actionCommand = e.getActionCommand();
                    System.out.println("actionCommand is: " + actionCommand);
                    // TODO fill in with your code
                }
            });

            buttonContainer.add(letterButton);
            letterButtons.add(letterButton);
        }

        JOptionPane.showMessageDialog(null, buttonContainer);
    }
}