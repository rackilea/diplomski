public class SMTPAuthenticator extends javax.mail.Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
        String username = "someone@somewhere.es";
        String password = "password";
        return new PasswordAuthentication(username, password);
    }
}