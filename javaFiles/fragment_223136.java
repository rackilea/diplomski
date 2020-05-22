import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Keypad extends JFrame implements ActionListener {

    private JButton buttonR = new JButton("R");
    private JButton button0 = new JButton("0");
    private JButton buttonE = new JButton("E");

    public Keypad() {
        setTitle("Keypad");
        setSize(220, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 3, 2, 2));
        for (int i = 1; i < 10; i++) {
            addButton(new JButton(String.valueOf(i)));
        }

        addButton(buttonR);
        addButton(button0);
        addButton(buttonE);

        setResizable(false);
        setVisible(true);
    }

    private void addButton(JButton button) {
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}