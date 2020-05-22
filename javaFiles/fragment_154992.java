import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.auth.LoginAdapter;
import org.jdesktop.swingx.auth.LoginEvent;
import org.jdesktop.swingx.auth.LoginListener;
import org.jdesktop.swingx.auth.LoginService;

public class Demo {

    private JFrame frame;
    private String userName;
    private int failedAttemptsCount = 0;

    private void showLoginDialog() {

        frame = new JFrame("Welcome!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JXLoginPane loginPane = new JXLoginPane();

        LoginListener loginListener = new LoginAdapter() {
            @Override
            public void loginFailed(LoginEvent source) {
                failedAttemptsCount++;
                String message;
                switch(failedAttemptsCount) {
                    case 1: message = "Come on buddy! What happened?"; break;
                    case 2: message = "Did you just fail again?"; break;
                    case 3: message = "This is embarrassing..."; break;
                        default: message = "You should probably go home and get some sleep...";
                }
                loginPane.setErrorMessage(message);
            }

            @Override
            public void loginSucceeded(LoginEvent source) {
                Demo.this.userName = loginPane.getUserName();
                Demo.this.createAndShowGui();
            }
        };

        LoginService loginService = new LoginService() {
            @Override
            public boolean authenticate(String name, char[] password, String server) throws Exception {
                return name.equals("Sturm") 
                    && String.valueOf(password).equals("StackOverflow") ;
            }
        };

        loginService.addLoginListener(loginListener);
        loginPane.setLoginService(loginService);

        JXLoginPane.JXLoginDialog dialog = new JXLoginPane.JXLoginDialog(frame, loginPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        // if loginPane was cancelled or closed then its status is CANCELLED
        // and still need to dispose main JFrame to exiting application
        if(loginPane.getStatus() == JXLoginPane.Status.CANCELLED) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void createAndShowGui() {
        String welcomeMessage = String.format("Welcome %s ! You have successfuly loged in.", userName);
        JPanel panel = new JPanel();
        panel.add(new JLabel(welcomeMessage));

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().showLoginDialog();
            }
        });
    }
}