import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class DialogEg {
    private static void createAndShowGui() {

        // create JFrame for application
        JFrame frame = new JFrame("Dialog Eg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

@SuppressWarnings("serial")
class MainPanel extends JPanel {
    private JTextField valueField = new JTextField(5);

    public MainPanel() {
        valueField.setFocusable(false); // so user can't interact with it

        add(new JLabel("Value:"));
        add(valueField);
        add(new JButton(new GetValueAction("Get Value")));
    }

    private class GetValueAction extends AbstractAction {
        private SecondPanel secondPanel = new SecondPanel();

        public GetValueAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // get JPanel's top level window
            Window win = SwingUtilities.getWindowAncestor(MainPanel.this);

            // create jdialog that is modal
            JDialog dialog = new JDialog(win, "Get Value", ModalityType.APPLICATION_MODAL);
            dialog.add(secondPanel);

            // so the submit button will be activated when enter pressed:
            dialog.getRootPane().setDefaultButton(secondPanel.getSubmitButton());
            dialog.pack();
            dialog.setLocationRelativeTo(win);
            dialog.setVisible(true); // **** code flow stops here

            // and resumes here once dialog is no longer visible
            int value = secondPanel.getSpinnerValue();
            valueField.setText("" + value);
        }
    }
}

@SuppressWarnings("serial")
class SecondPanel extends JPanel {
    private SpinnerModel spinModel = new SpinnerNumberModel(-1, -1, 100, 1);
    private JSpinner spinner = new JSpinner(spinModel);
    private JButton submitButton = new JButton(new SubmitAction("Submit"));

    public SecondPanel() {
        add(spinner);
        add(submitButton);
    }

    public int getSpinnerValue() {
        return (Integer) spinner.getValue();
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    private class SubmitAction extends AbstractAction {
        public SubmitAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int value = getSpinnerValue();

            // get JPanel's top level window
            Window win = SwingUtilities.getWindowAncestor(SecondPanel.this);
            if (value < 0) {
                String msg = "Submitted value must cannot be negative. Please try again";
                JOptionPane.showMessageDialog(win, msg, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                spinner.requestFocusInWindow(); // bring focus back to spinner
            } else {
                spinner.requestFocusInWindow();
                win.dispose();  // get rid of dialog
            }
        }
    }
}