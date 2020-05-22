import javax.swing.*;
import java.awt.*;

public class MyOptionPane {

    static Object showInputDialog(Object f,  Object message, String title, int messageType,
                                  Icon ico, Object[] options, Object initValue) {


        JOptionPane pane = new JOptionPane(message, messageType, JOptionPane.OK_CANCEL_OPTION,
                ico, options,  initValue);

        JDialog dialog = pane.createDialog((Component) f, title);
        if (!dialog.isResizable()) {
            dialog.setResizable(true);
        }
        pane.setInitialSelectionValue(pane.getInitialValue()); // set it
        pane.setWantsInput(true);

        dialog.pack();
        dialog.setVisible(true);

        return pane.getInputValue();
    }
}