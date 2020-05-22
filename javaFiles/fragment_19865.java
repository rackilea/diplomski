import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 * @author dic19
 */
public class Demo {

    private Object backupSpinnerValue;
    private Boolean backupButtonState;

    public void createAndShowGUI() {

        final JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 4, 1));
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spinner.getEditor();
        JFormattedTextField textField = editor.getTextField();
        textField.addPropertyChangeListener("value", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Object oldValue = evt.getOldValue();
                Object newValue = evt.getNewValue();
                if (!evt.getNewValue().equals(backupSpinnerValue)) { // Just ignore if they're the same
                    if (Demo.this.confirmChanges(oldValue, newValue)) {
                        backupSpinnerValue = newValue;
                    } else {
                        spinner.setValue(backupSpinnerValue);
                    }
                }
            }
        });

        final JToggleButton button = new JToggleButton("Toggle");
        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Boolean isSelected = e.getStateChange() == ItemEvent.SELECTED;
                if (!isSelected.equals(backupButtonState)) { // Just ignore if they're the same
                    if (Demo.this.confirmChanges(backupButtonState, isSelected)) {
                        backupButtonState = isSelected;
                    }
                    button.setSelected(backupButtonState);
                }
            }
        });

        backupSpinnerValue = spinner.getValue();
        backupButtonState = button.isSelected();

        JPanel content = new JPanel();
        content.add(spinner);
        content.add(button);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(content);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private boolean confirmChanges(Object oldValue, Object newValue) {
        String message = String.format("Do you want to confirm changes from value '%1s' to '%2s'?", oldValue, newValue);
        int option = JOptionPane.showConfirmDialog(null, message, "Confirm changes", JOptionPane.OK_CANCEL_OPTION);
        return option == JOptionPane.OK_OPTION;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }
}