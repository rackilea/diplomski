import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * This is the actual GUI class, which will get
 * values from the JDIalog class.
 */
public class GetDialogValues extends JFrame
{
    private JTextField userField;
    private JTextField questionField;

    public GetDialogValues()
    {
        super("JFRAME");
    }

    private void createAndDisplayGUI(GetDialogValues gdv)
    {       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 2));

        JLabel userName = new JLabel("USERNAME : ");
        userField = new JTextField();
        JLabel questionLabel = new JLabel("Are you feeling GOOD ?");
        questionField = new JTextField();

        contentPane.add(userName);
        contentPane.add(userField);
        contentPane.add(questionLabel);
        contentPane.add(questionField);

        getContentPane().add(contentPane);
        pack();
        setVisible(true);

        InputDialog id = new InputDialog(gdv, "Get INPUT : ", true);
    }

    public void setValues(final String username, final String answer)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                userField.setText(username);
                questionField.setText(answer);
            }
        });
    }

    public static void main(String... args)
    {
        Runnable runnable = new Runnable()
        {
            public void run()
            {
                GetDialogValues gdv = new GetDialogValues();
                gdv.createAndDisplayGUI(gdv);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}

class InputDialog extends JDialog
{
    private GetDialogValues gdv;
    private JTextField usernameField;
    private JTextField questionField;
    private JButton submitButton;
    private ActionListener actionButton = new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            if (usernameField.getDocument().getLength() > 0
                && questionField.getDocument().getLength() > 0)
            {
                gdv.setValues(usernameField.getText().trim()
                    , questionField.getText().trim());
                dispose();
            }
            else if (usernameField.getDocument().getLength() == 0)
            {
                JOptionPane.showMessageDialog(null, "Please Enter USERNAME."
                    , "Invalid USERNAME : ", JOptionPane.ERROR_MESSAGE);
            }
            else if (questionField.getDocument().getLength() == 0)
            {
                JOptionPane.showMessageDialog(null, "Please Answer the question"
                    , "Invalid ANSWER : ", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    public InputDialog(GetDialogValues gdv, String title, boolean isModal)
    {
        this.gdv = gdv;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setModal(isModal);
        setTitle(title);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        JLabel usernameLabel = new JLabel("Enter USERNAME : ");
        usernameField = new JTextField();
        JLabel questionLabel = new JLabel("How are you feeling ?");
        questionField = new JTextField();

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(questionLabel);
        panel.add(questionField);

        submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(actionButton);

        add(panel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }
}