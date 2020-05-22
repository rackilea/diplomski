import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FocusPasswordFieldInOptionPaneDemo implements Runnable
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new FocusPasswordFieldInOptionPaneDemo());
    }

    @Override
    public void run()
    {
        JTextField uname = new JTextField("user");
        JPasswordField passwd = new JPasswordField();
        JTextField serverAddress = new JTextField("server");
        JTextField port = new JTextField(Integer.toString(1337));
        final JComponent[] inputs = new JComponent[] {new JLabel("Username"), uname, new JLabel("Password"), passwd,
                new JLabel("Server Address"), serverAddress, new JLabel("Server Port"), port};

        makeSurePasswordFieldGetsFocus(passwd);

        int answer = JOptionPane.showConfirmDialog(null, inputs, "Enter Connection Details", OK_CANCEL_OPTION, PLAIN_MESSAGE);
        System.out.println(answer);
    }

    /**
     * {@link JOptionPane} makes the [OK] button default in the dialog and makes it focused.
     * <p>
     * So via a couple of listeners we can wait until the button gets permanent focus and then switch focus to the password field.
     */
    private void makeSurePasswordFieldGetsFocus(final JPasswordField passwd)
    {
        passwd.addHierarchyListener(new HierarchyListener()
        {
            HierarchyListener hierarchyListener = this;

            @Override
            public void hierarchyChanged(HierarchyEvent e)
            {
                JRootPane rootPane = SwingUtilities.getRootPane(passwd);
                if (rootPane != null)
                {
                    final JButton okButton = rootPane.getDefaultButton();
                    if (okButton != null)
                    {
                        okButton.addFocusListener(new FocusAdapter()
                        {
                            @Override
                            public void focusGained(FocusEvent e)
                            {
                                if (!e.isTemporary())
                                {
                                    passwd.requestFocusInWindow();
                                    passwd.removeHierarchyListener(hierarchyListener);
                                    okButton.removeFocusListener(this);
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}