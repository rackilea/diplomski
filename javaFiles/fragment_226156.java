import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Example extends JFrame implements ActionListener {
    private final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private JButton[] buttons = new JButton[26];
    private JTextArea text = new JTextArea();

    public Example() {
        super("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < letters.length; i++) {
            buttons[i] = new JButton(letters[i]);
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
        add(text);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        text.append(event.getActionCommand());
    }

    public static void main(String[] args) {
        Example ex = new Example();
    }
}