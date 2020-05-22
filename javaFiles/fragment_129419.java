package popUpTest;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopUpTest
{

private JFrame frame;
private JPasswordField passSourcePassword;
private JTextField txtSourceUserName;
private JTextField txtTargetUserName;
private JPasswordField passTargetPassword;
private JTextArea textArea;

/**
 * Launch the application.
 */
public static void main(String[] args)
{
    EventQueue.invokeLater(new Runnable()
    {
        public void run()
        {
            try
            {
                PopUpTest window = new PopUpTest();
                window.frame.setVisible(true);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the application.
 */
public PopUpTest()
{
    initialize();
}

/**
 * Initialize the contents of the frame.
 */
private void initialize()
{
    frame = new JFrame();
    frame.setBounds(100, 100, 444, 403);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    JButton popUpButton = new JButton("Click to Show Pop Up To Enter Detail");
    popUpButton.setBounds(15, 100, 365, 85);
    popUpButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new MyDialog();
        }
    });
    frame.getContentPane().add(popUpButton);

    textArea = new JTextArea();
    textArea.setBounds(15, 252, 365, 85);
    frame.getContentPane().add(textArea);

    JButton btnShowAllDetails = new JButton("Show All Details:");
    btnShowAllDetails.setBounds(15, 207, 226, 29);
    frame.getContentPane().add(btnShowAllDetails);


    btnShowAllDetails.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent arg0)
        {
            textArea.append(txtSourceUserName.getText() + "\n");
            textArea.append(passSourcePassword.getText() + "\n");
            textArea.append(txtTargetUserName.getText() + "\n");
            textArea.append(passTargetPassword.getText() + "\n");
        }

    });

}

public JTextArea getTextArea() {
    return textArea;
}



private class MyDialog extends JDialog {
    private final JPasswordField passSourcePassword;
    private final JTextField txtSourceUserName;
    private final JTextField txtTargetUserName;
    private final JPasswordField passTargetPassword;

    public MyDialog() {
        setSize(600, 500);
        setLayout(null);

        JLabel lblEnterBelowDetails = new JLabel("Enter Below Details:");
        lblEnterBelowDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEnterBelowDetails.setBounds(15, 26, 187, 20);
        add(lblEnterBelowDetails);

        JLabel lblSourceUserName = new JLabel("SourceUserName:");
        lblSourceUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSourceUserName.setBounds(15, 62, 170, 20);
        add(lblSourceUserName);

        passSourcePassword = new JPasswordField();
        passSourcePassword.setBounds(15, 153, 147, 26);
        add(passSourcePassword);

        JLabel lblSourcePassword = new JLabel("SourcePassword:");
        lblSourcePassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSourcePassword.setBounds(15, 132, 147, 20);
        add(lblSourcePassword);

        txtSourceUserName = new JTextField();
        txtSourceUserName.setBounds(16, 81, 146, 26);
        add(txtSourceUserName);
        txtSourceUserName.setColumns(10);

        JLabel lblTargetUserName = new JLabel("TargetUserName:");
        lblTargetUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTargetUserName.setBounds(240, 62, 170, 20);
        add(lblTargetUserName);

        txtTargetUserName = new JTextField();
        txtTargetUserName.setColumns(10);
        txtTargetUserName.setBounds(241, 81, 146, 26);
        add(txtTargetUserName);

        JLabel lblTargetPassword = new JLabel("TargetPassword:");
        lblTargetPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTargetPassword.setBounds(240, 132, 147, 20);
        add(lblTargetPassword);

        passTargetPassword = new JPasswordField();
        passTargetPassword.setBounds(240, 153, 147, 26);
        add(passTargetPassword);

        JButton publishButton = new JButton("Publish");
        publishButton.setBounds(100, 200, 146, 26);
        add(publishButton);

        publishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(txtSourceUserName.getText() + "\n");
                textArea.append(passSourcePassword.getText() + "\n");
                textArea.append(txtTargetUserName.getText() + "\n");
                textArea.append(passTargetPassword.getText() + "\n");
                dispose();
            }
        });


        setVisible(true);

    }
}
}