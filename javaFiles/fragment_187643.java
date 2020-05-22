public class change_username extends JFrame {

    private JLabel uT1, pwT, uCh, statusBar;
    private JTextField username_input, username_change;
    private JPasswordField password_input;

    // ADD IT HERE **************************************
    private String userName, passWord;

    public String getUserName(){
        return this.userName;
    } 

    public void setUserName(String givenUserName){
        this.userName = givenUserName;
    }

    // **************************************


    public change_username() {
        super("Change Username"); 
        setPreferredSize (new Dimension (400, 85));
        setLayout (null);

    // YOUR CODE HERE


// CLASS 3
public class create_account extends JFrame{
    private String u1, pw1;
    class4 objClass4 = new class4();
    u1 = objClass4.getUserName();

    // YOUR code here.......