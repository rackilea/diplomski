import javax.swing.JOptionPane;

public class LoginProgram {

    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Username: ");
        String password = JOptionPane.showInputDialog("Password: ");

        if (username == null || password == null) {
            JOptionPane.showMessageDialog(null, "Not enough information.");
        } else if (username != null && password != null && username.contentEquals("pass")
                && password.contentEquals("fish") || username.contentEquals("italy") && password.contentEquals("shield")
                || username.contentEquals("PASS") && password.contentEquals("FISH")
                || username.contentEquals("ITALY") && password.contentEquals("SHIELD")) {
            JOptionPane.showMessageDialog(null, "You're in our system.");
        } else {
            JOptionPane.showMessageDialog(null, "You're suspicious.");
        }
    }
}