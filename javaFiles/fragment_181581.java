import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

@SuppressWarnings("serial")
public class SchuelerPanel extends JPanel {
    private static final String TITLE_TEXT = "Lorem Ipsum Dolor Sit Amet";
    public static final String[] LABEL_STRINGS = {"Monday", "Tuesday", "Wednesday"};
    private Map<String, JTextField> labelFieldMap = new HashMap<>();

    public SchuelerPanel() {
        JLabel titleLabel = new JLabel(TITLE_TEXT, JLabel.CENTER);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        JPanel labelFieldPanel = new JPanel(new GridBagLayout());
        for (int i = 0; i < LABEL_STRINGS.length; i++) {
            addToPanel(labelFieldPanel, LABEL_STRINGS[i], i);
        }

        // Don't do what I'm doing here: avoid "magic" numbers!
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
        setLayout(new BorderLayout(10, 10));
        add(titleLabel, BorderLayout.PAGE_START);
        add(labelFieldPanel, BorderLayout.CENTER);
    }

    // get the text from the JTextField based on the JLabel associated with it
    public String getText(String labelText) {
        JTextField textField = labelFieldMap.get(labelText);
        if (textField == null) {
            throw new IllegalArgumentException("For labelText: " + labelText);
        }
        return textField.getText();
    }

    private void addToPanel(JPanel gblUsingPanel, String labelString, int row) {
        JLabel label = new JLabel(labelString);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        JTextField textField = new JTextField(10);
        labelFieldMap.put(labelString, textField);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gblUsingPanel.add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gblUsingPanel.add(textField, gbc);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("SchuelerPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SchuelerPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}