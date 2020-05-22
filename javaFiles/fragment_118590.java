import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MainUI extends JFrame{

ButtonController buttonController;

public MainUI() {
    super();
    buttonController=new ButtonController(this);
    initialize();
}

private void initialize() {

    JTextField userName=new JTextField();
    JPasswordField passwordField=new JPasswordField();

    JButton loginButton=new JButton("Login");
    loginButton.setActionCommand(ButtonController.LOGIN_COMMAND);

    JButton cancelButton=new JButton("Cancel");
    cancelButton.setActionCommand(ButtonController.CANCEL_COMMAND);

    JPanel contentPane=new JPanel();
    contentPane.setLayout(new GridLayout(3,2));
    contentPane.add(new JLabel("Username : "));
    contentPane.add(userName);
    contentPane.add(new JLabel("Password : "));
    contentPane.add(passwordField);
    contentPane.add(loginButton);
    contentPane.add(cancelButton);

    buttonController.registerButton(loginButton);
    buttonController.registerButton(cancelButton);

    setContentPane(contentPane);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    pack();
}


/**
 * @param args
 */
public static void main(String[] args) {
    MainUI ui=new MainUI();
    ui.setVisible(true);
}


}


class ButtonController implements ActionListener
{
private MainUI mainUI;

public static String LOGIN_COMMAND="Login";
public static String CANCEL_COMMAND="Cancel";

public ButtonController(MainUI mainUi ) {
    this.mainUI=mainUi;
}

public void registerButton(JButton button)
{
    button.addActionListener(this);
}

public void deRegisterButton(Button button)
{
    button.removeActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals(LOGIN_COMMAND))
    {
        ((JButton)e.getSource()).setEnabled(false);
    }
    if(e.getActionCommand().equals(CANCEL_COMMAND))
    {
        mainUI.dispose();
    }
}

}