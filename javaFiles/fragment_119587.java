import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleCalc extends JPanel {
    private static final int GAP = 4;
    private JSpinner spinner1 = new JSpinner(new SpinnerNumberModel(0, -1000, 1000, 1));
    private JSpinner spinner2 = new JSpinner(new SpinnerNumberModel(0, -1000, 1000, 1));
    private JTextField resultField = new JTextField(10);
    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");

    public SimpleCalc() {
        // add anonymous listeners to each JButton
        addButton.addActionListener(e -> add());
        subtractButton.addActionListener(e -> subtract());

        // put both buttons within a JPanel that uses grid layout
        // 1 row, variable number of columns, gap between components
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, GAP));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);

        resultField.setFocusable(false);
        resultField.setEditable(false);

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        // use GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // start at x position is 0, and stay there
        gbc.gridx = 0;
        // y position increments each time
        gbc.gridy = GridBagConstraints.RELATIVE;
        // stretch components horizontally not vertically
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        // gap between componentns
        gbc.insets = new Insets(GAP, GAP, GAP, GAP);

        add(spinner1, gbc);
        add(spinner2, gbc);
        add(resultField, gbc);
        add(buttonPanel, gbc);
    }

    public void add() {
        int value1 = (int) spinner1.getValue();
        int value2 = (int) spinner2.getValue();
        int result = value1 + value2;
        resultField.setText(String.valueOf(result));
    }

    public void subtract() {
        int value1 = (int) spinner1.getValue();
        int value2 = (int) spinner2.getValue();
        int result = value1 - value2;
        resultField.setText(String.valueOf(result));
    }

    private static void createAndShowGui() {
        SimpleCalc mainPanel = new SimpleCalc();

        JFrame frame = new JFrame("SimpleCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}