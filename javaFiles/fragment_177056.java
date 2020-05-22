// Class ComboBoxTextAndNumber:

import java.awt.event.ItemEvent;
import java.util.*;
import java.util.Vector;
import javax.swing.*;

public class ComboBoxTextAndNumber {
    public static void main(final String[] arguments) {
        SwingUtilities.invokeLater(
                () -> new ComboBoxTextAndNumber().createAndShowGui()
        );
    }

    private void createAndShowGui() {
        final JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final Vector<Interval> intervals = new Vector<>(Arrays.asList(
                new Interval("every 5 years", 5 * 365 * 24 * 60 * 60),
                new Interval("every day", 24 * 60 * 60))
        );

        final JPanel panel = new JPanel();
        final JComboBox<Interval> comboBox = new JComboBox<>(intervals);
        panel.add(comboBox);
        frame.getContentPane().add(panel);

        comboBox.addItemListener(
                itemEvent -> {
                    if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                        final Interval interval = (Interval) comboBox.getSelectedItem();
                        System.out.println(interval.getSeconds());
                    }
                }
        );

        frame.setVisible(true);
    }
}


// Class Interval:

public class Interval {
    private final String description;
    private final long seconds;

    public Interval(final String description, final long seconds) {
        this.description = description;
        this.seconds = seconds;
    }

    public String getDescription() {
        return description;
    }

    public long getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}