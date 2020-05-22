public class Login extends LoginDesign implements Button.ClickListener {
private static final long serialVersionUID = 1L;

private UI mainUI;

private ClickListener listner = this;

public Panel createLoginPanel(UI mainUI) {
    this.mainUI = mainUI;
    Login login = new Login();
    btnLogin.addClickListener(listner);
    lblError.setValue("Problem");
    System.out.println(lblError.getValue());
    return login;
}....