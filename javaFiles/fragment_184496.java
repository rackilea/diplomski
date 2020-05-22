import javax.swing.JFrame;

public class OtherClass extends JFrame
{
    final Login loginClass;

    private String userName;
    private String userPassword;

    public OtherClass(Login e)
    {
        loginClass = e;
        userName = loginClass.getUserName();
        userPassword = loginClass.getUserPassword();

        System.out.println("Your User Name is: " + userName);
        System.out.println("Your Password is: " + userPassword);
    }   
}