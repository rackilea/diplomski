import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class BuildingTest extends JPanel {
    // model to hold all the building name strings
    private DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>(new String[] {"Foo", "Bar", "Baz"});
    private JComboBox<String> selectBuildingCombo = new JComboBox<>(comboModel);

    // text field to allow user to add more strings to model
    private JTextField entryField = new JTextField(10);
    private JButton enterBuildingBtn = new JButton("Enter Building Name");    

    public BuildingTest() {
        // the size of the combobox larger
        selectBuildingCombo.setPrototypeDisplayValue("abcdefghijklmnopqrstuv");
        add(selectBuildingCombo);
        add(new JLabel("Enter new building name:"));
        add(entryField);
        add(enterBuildingBtn);

        selectBuildingCombo.addActionListener(e -> {
            String selection = (String) selectBuildingCombo.getSelectedItem();
            if (selection != null) {
                System.out.println("Selected Item: " + selection);
            }
        });

        // occurs when user wants to add to combo model
        ActionListener enterBuildingListener = e -> {
            // get text from text field
            String text = entryField.getText().trim();
            if (!text.isEmpty()) {
                // if not empty, add to model
                comboModel.addElement(text);
                entryField.selectAll();
            }
        };

        // add this action listener to both the text field and the button
        enterBuildingBtn.addActionListener(enterBuildingListener);
        entryField.addActionListener(enterBuildingListener);
        enterBuildingBtn.setMnemonic(KeyEvent.VK_E);
    }

    private static void createAndShowGui() {
        BuildingTest mainPanel = new BuildingTest();

        JFrame frame = new JFrame("Building Test");
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