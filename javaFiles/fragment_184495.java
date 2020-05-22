import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;

public class Login extends JFrame
{
    private static final int FRAME_WIDTH = 250;
    private static final int FRAME_HEIGHT = 100;

    private JPanel labelPanel;
    private JPanel textPanel;

    private JTextField userName;
    private JTextField userPassword;

    private JButton loginButton;

    private String userNameString;
    private String userPasswordString;

    public Login()
    {
        super("Please Login");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1));
        add(labelPanel, BorderLayout.WEST);
        JLabel userLabel = new JLabel("User Name: ");
        labelPanel.add(userLabel);
        JLabel passwordLabel = new JLabel("Password: ");
        labelPanel.add(passwordLabel);

        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));
        add(textPanel, BorderLayout.CENTER);
        userName = new JTextField(30);
        userPassword = new JTextField(30);
        textPanel.add(userName);
        textPanel.add(userPassword);

        loginButton = new JButton("Login");
        FrameListener loginListener = new FrameListener();
        loginButton.addActionListener(loginListener);
        add(loginButton, BorderLayout.SOUTH);        
    }

    private class FrameListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand = e.getActionCommand();

            if(actionCommand.equals("Login"))
            {
                if(!(userName.getText().equals("")) && !(userPassword.getText().equals("")))
                {
                    userNameString = userName.getText();
                    userPasswordString = userPassword.getText();

                    //Access your database of credentials here


                    SwingUtilities.invokeLater(new Runnable() 
                    {
                        @Override
                        public void run() 
                        {
                            OtherClass mainProgram = new OtherClass(Login.this);
                            mainProgram.setVisible(true);
                        }
                    });
                    dispose();
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
            }
        });
    }

    public String getUserName()
    { 
        return userNameString;
    }

    public String getUserPassword()
    {
        return userPasswordString;
    }
}