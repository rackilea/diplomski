import java.awt.*;
import javax.swing.*;

public class ManyOptions {

    ManyOptions() {
        initUI();
    }

    public void initUI() {
        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4",
            "Option 5", "Option 6", "Option 7", "Option 8", "Option 9",
            "Option 10", "Option 11", "Option 12", "Option 13", "Option 14",
            "Option 15"};

        JComboBox combo = new JComboBox(options);
        int result = JOptionPane.showConfirmDialog(
                null,
                combo,
                "Select One",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Selected Index: " + combo.getSelectedIndex());
        } else {
            System.out.println("choice cancelled..");
        }

        // old way, for comparison..
        int displayoptions = JOptionPane.showOptionDialog(
                null,
                "select one",
                "Title",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);
        System.out.println("displayoptions: " + displayoptions);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                ManyOptions o = new ManyOptions();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}