import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AlbertCardonaProg7 extends JFrame {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 250;
    private static final String[] colorValues = { "red", "white", "yellow",
        "green", "blue" };

    private final JLabel[] inputLabels = new JLabel[colorValues.length];
    private final JTextField[] inputFields = new JTextField[colorValues.length];

    public AlbertCardonaProg7() {
        //Create the UI controls
        for (int i = 0; i < colorValues.length; i++) {
            inputLabels[i] = new JLabel("Input color number " + i + ":");
            inputFields[i] = new JTextField(15);
            inputFields[i].addActionListener(new Listener());

            add(inputLabels[i]);
            add(inputFields[i]);
        }

        setTitle("MEMORY GAME");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // See if there are any wrong answers
            boolean correct = true;
            for(int i = 0; i < colorValues.length; i++) {
                if (!inputFields[i].getText().equals(colorValues[i])) {
                    correct = false;
                }
            }

            if(correct) {
                JOptionPane.showMessageDialog(null, 
                        "Congratulations, you got the answer correct");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Sorry, your answer is wrong", "Error",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        String colors = "";
        for (int i = 0; i < colorValues.length; i++) {
            colors += colorValues[i] + "  ";
        }

        JOptionPane.showMessageDialog(null, "How good is your memory.\n"
                + "See if you can memorize this sequence.\n\n" + colors,
                "Message", JOptionPane.INFORMATION_MESSAGE);

        AlbertCardonaProg7 outBox = new AlbertCardonaProg7();

    }
}