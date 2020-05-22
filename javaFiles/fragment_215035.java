import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutEg extends JPanel {
    private static final int KILO_FIELD_COLS = 15;
    private static final int GAP = 3;
    private JTextField kiloTextField = new JTextField(KILO_FIELD_COLS);
    private JButton calcButton = new JButton("Calculate");
    private JButton alertButton = new JButton("Alert");

    public LayoutEg() {
        // add ActionListeners etc.... 

        JPanel enterPanel = new JPanel();
        enterPanel.add(new JLabel("Enter a distance in kilometers:"));
        enterPanel.add(kiloTextField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
        buttonPanel.add(calcButton);
        buttonPanel.add(alertButton);

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(0, 1));
        add(enterPanel);
        add(buttonPanel);
    }

    private static void createAndShowGui() {
        LayoutEg mainPanel = new LayoutEg();

        JFrame frame = new JFrame("Kilometer Converter");
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