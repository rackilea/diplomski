import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoopingJOptionPane {
    private static final String REGEX = "[0-9]+";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new LoopingJOptionPane()::createAndShowGui);
    }

    private void createAndShowGui() {
        boolean found = true;
        do { //This repeats this code if input is incorrect
            Pattern pattern = Pattern.compile(REGEX);

            String name = JOptionPane.showInputDialog("Enter your name");
            Matcher matcher = pattern.matcher(name); //We try to find if there's a number in our string

            found = matcher.find();

            if (found) { //If there's a number, show this message
                JOptionPane.showMessageDialog(null, "Please write only letters");
            } else { //Otherwise show this one
                JOptionPane.showMessageDialog(null, "Welcome " + name);
            }
        } while (found); //If it has no numbers, don't repeat
    }
}