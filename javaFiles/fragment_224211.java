import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class Radio {

    private static final String PREF_BUTTON_INDEX = "color button";
    private final Preferences prefs = Preferences.userNodeForPackage(getClass());


    private static final String[] COLORS = { "#ededed", "#ffffff", "#a00000" };
    private List<JRadioButton> buttons;
    private JLabel output;  // so we can see something, simulating usage of color

    private Radio() {
        buttons = new ArrayList<>();
        SwingUtilities.invokeLater(this::initGUI);
    }

    private void initGUI() {
        JPanel panel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < COLORS.length; i++) {
            JRadioButton button = new JRadioButton(COLORS[i]);
            button.addActionListener(this::buttonSelected);
            group.add(button);
            panel.add(button);
            buttons.add(button);
        }

        output = new JLabel("undefined");
        output.setBorder(new TitledBorder("Color:"));
        panel.add(output);

        int colorIndex = prefs.getInt(PREF_BUTTON_INDEX, -1);
        if (colorIndex != -1) {
            buttons.get(colorIndex).setSelected(true);
            output.setText(COLORS[colorIndex]);
        }

        JOptionPane.showMessageDialog(null, panel);
    }

    private void buttonSelected(ActionEvent ev) {
        int index = buttons.indexOf(ev.getSource());
        if (index != -1) {
            output.setText(COLORS[index]);
            prefs.putInt(PREF_BUTTON_INDEX, index);
        }
    }

    public static void main(String[] args) {
        new Radio();
    }
}