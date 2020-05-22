import java.awt.Component;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

@SuppressWarnings("serial")
public class TempConversion2 extends JPanel {
    private ToFromPanel fromPanel = new ToFromPanel("From", true);
    private ToFromPanel toPanel = new ToFromPanel("To", false);
    private ButtonPanel buttonPanel = new ButtonPanel(fromPanel, toPanel);

    public TempConversion2() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(fromPanel);
        add(toPanel);
        add(buttonPanel);
    }

    private static void createAndShowGui() {
        TempConversion2 mainPanel = new TempConversion2();

        JFrame frame = new JFrame("Temp Convert");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class ButtonPanel extends JPanel {

    public ButtonPanel(ToFromPanel fromPanel, ToFromPanel toPanel) {
        add(new JButton(new ConvertAction("Convert", fromPanel, toPanel)));
        add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));
    }

}

@SuppressWarnings("serial")
class ConvertAction extends AbstractAction {
    private ToFromPanel fromPanel;
    private ToFromPanel toPanel;

    public ConvertAction(String name, ToFromPanel fromPanel, ToFromPanel toPanel) {
        super(name);
        int mnemonic = (int) name.charAt(0);
        putValue(MNEMONIC_KEY, mnemonic);
        this.fromPanel = fromPanel;
        this.toPanel = toPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = fromPanel.getText();
        try {
            double fromTemp = Double.parseDouble(text.trim());
            TempScale fromScale = fromPanel.getTempScalesPanel().getSelectedTempScale();
            double kelvinValue = fromScale.convertToKelvin(fromTemp);

            TempScale toScale = toPanel.getTempScalesPanel().getSelectedTempScale();
            double toValue = toScale.convertFromKelvin(kelvinValue);

            String toValueString = String.format("%.2f", toValue);
            toPanel.setText(toValueString);
        } catch (NumberFormatException e1) {
            Component parentComponent = fromPanel;
            String message = "Text must be a valid number: " + text;
            String title = "Invalid Text Entered";
            int messageType = JOptionPane.ERROR_MESSAGE;
            JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
            fromPanel.setText("");
        }
    }
}

@SuppressWarnings("serial")
class ExitAction extends AbstractAction {
    public ExitAction(String name, int mnemonic) {
        super(name);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

@SuppressWarnings("serial")
class ToFromPanel extends JPanel {
    private String title;
    private TempScalesPanel tempScalesPanel = new TempScalesPanel();
    private JTextField tempTextField = new JTextField(3);

    public ToFromPanel(String title, boolean textFieldEnabled) {
        this.title = title;
        tempTextField.setFocusable(textFieldEnabled);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        bottomPanel.add(new JLabel("Temperature:"));
        bottomPanel.add(Box.createHorizontalStrut(8));
        bottomPanel.add(tempTextField);

        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(tempScalesPanel);
        add(bottomPanel);
    }

    public String getTitle() {
        return title;
    }

    public TempScalesPanel getTempScalesPanel() {
        return tempScalesPanel;
    }

    public String getText() {
        return tempTextField.getText();
    }

    public void setText(String text) {
        tempTextField.setText(text);
    }
}

@SuppressWarnings("serial")
class TempScalesPanel extends JPanel {
    private ButtonGroup buttonGroup = new ButtonGroup();
    private Map<ButtonModel, TempScale> buttonTempMap = new HashMap<>();

    public TempScalesPanel() {
        for (TempScale tempScale : TempScale.values()) {
            JRadioButton radioButton = new JRadioButton(tempScale.getName());
            add(radioButton);
            buttonGroup.add(radioButton);
            buttonTempMap.put(radioButton.getModel(), tempScale);
            // set first button as selected by default
            if (buttonGroup.getSelection() == null) {
                buttonGroup.setSelected(radioButton.getModel(), true);
            }
        }
    }

    public TempScale getSelectedTempScale() {
        ButtonModel model = buttonGroup.getSelection();
        return buttonTempMap.get(model);
    }
}