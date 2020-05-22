public class LoginDialog extends JDialog {
    private LoginPanel loginPane;
    public LoginDialog(Window wnd) {
        super(wnd);
        setModal(true);
        loginPane = new LoginPanel();
        setLayout(new BorderLayout());
        add(loginPane);
        // Typically, I create another panel and add the buttons I want to use to it.
        // These buttons would call dispose once they've completed there work
    }

    public Login getLogin() {
        return loginPane.getLogin();
    }

    public boolean isSuccessfulLogin() {
        return loginPane.isSuccessfulLogin();
    }
}