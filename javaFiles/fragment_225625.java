import java.awt.event.ItemEvent;
import javax.swing.*;

public class TestCheckBox extends JPanel {
    private static final long serialVersionUID = 1L;
    private JCheckBox moreDetailsCheck = new JCheckBox("More Details", false);
    private JTextField inputFieldUser = new JTextField(15);

    public TestCheckBox() {
        inputFieldUser.setEnabled(false);
        add(moreDetailsCheck);
        add(inputFieldUser);

        // add a listener to the JCheckBox
        moreDetailsCheck.addItemListener(e -> {
            // if checkbox selected, enable the text field. else disable it
            inputFieldUser.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
        });
    }

    private static void createAndShowGui() {
        TestCheckBox mainPanel = new TestCheckBox();

        JFrame frame = new JFrame("Test CheckBox");
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