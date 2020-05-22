import javax.swing.JFrame;

public class loginFrameAdmin {

    private JFrame frameLogin;
    public loginFrameAdmin() {
        frameLogin = new JFrame("Login Amministratore");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(600, 400);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setVisible(true);
    }
}