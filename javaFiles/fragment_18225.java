import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TestGridBagLayout {

    protected void initUI() {
        JFrame frame = new JFrame(TestGridBagLayout.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("A button");
        JTextField textField = new JTextField();
        JLabel label = new JLabel("A cool long nice label that will stretch.");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;// Fill the "cell" in both direction
        gbc.weightx = 1.0;// Allocate extra-width to the label
        gbc.weighty = 1.0;// Allocate extra-height to the label
        gbc.gridwidth = GridBagConstraints.REMAINDER;// The label takes all the available width of the "row"
        panel.add(label, gbc);

        gbc.weighty = 0; // Don't stretch TF vertically
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        panel.add(textField, gbc);
        gbc.weightx = 0; // No extra horizontal space is given to the button
        gbc.fill = GridBagConstraints.NONE; // No fill for the button
        panel.add(button, gbc);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestGridBagLayout().initUI();
            }
        });
    }

}