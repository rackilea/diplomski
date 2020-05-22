import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.UNINITIALIZED_VALUE;
import static javax.swing.JOptionPane.VALUE_PROPERTY;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        String pick = Picker.pick();
        System.out.println("You picked " + pick);
        System.exit(0);
    }

    public static class Picker {

        public static String pick() {
            String[] choices = {"Rock", "Paper", "Scissors"};

            JOptionPane pane = new JOptionPane("Please, make your choice", JOptionPane.QUESTION_MESSAGE,
                    OK_CANCEL_OPTION, null, null, null);
            pane.setWantsInput(true);
            pane.setSelectionValues(choices);
            pane.setInitialSelectionValue(choices[0]);

            JDialog dialog = new JDialog();
            dialog.setModal(true);

            PropertyChangeListener listener = new PropertyChangeListener() {
                public void propertyChange(PropertyChangeEvent event) {
                    // Let the defaultCloseOperation handle the closing
                    // if the user closed the window without selecting a button
                    // (newValue = null in that case).  Otherwise, close the dialog.
                    if (dialog.isVisible()
                            && (event.getPropertyName().equals(VALUE_PROPERTY))
                            && event.getNewValue() != null
                            && event.getNewValue() != JOptionPane.UNINITIALIZED_VALUE) {
                        dialog.setVisible(false);
                    }
                }
            };

            WindowAdapter adapter = new WindowAdapter() {
                private boolean gotFocus = false;

                public void windowClosing(WindowEvent we) {
                    pane.setValue(null);
                }

                public void windowClosed(WindowEvent e) {
                    dialog.removePropertyChangeListener(listener);
                    dialog.getContentPane().removeAll();
                }

                public void windowGainedFocus(WindowEvent we) {
                    // Once window gets focus, set initial focus
                    if (!gotFocus) {
                        pane.selectInitialValue();
                        gotFocus = true;
                    }
                }
            };
            dialog.addWindowListener(adapter);
            dialog.addWindowFocusListener(adapter);
            dialog.addComponentListener(new ComponentAdapter() {
                public void componentShown(ComponentEvent ce) {
                    // reset value to ensure closing works properly
                    pane.setValue(JOptionPane.UNINITIALIZED_VALUE);
                }
            });

            pane.addPropertyChangeListener(listener);

            dialog.add(pane);
            //dialog.pack();
            //dialog.setLocationRelativeTo(null);
            dialog.setSize(970, 300); // This is bad idea, use an EmptyBorder instead
            dialog.setLocation(950, 0);
            dialog.setVisible(true);

            String pick = null;
            Object value = pane.getInputValue();
            if (value != UNINITIALIZED_VALUE) {
                pick = value.toString();
            }

            return pick;

        }

    }

}