public class AccountApplet2 extends JApplet implements ActionListener {    
    //  For West
    public JLabel  ai       = new JLabel("Account ID ");
    public JTextField  aitf = new JTextField();
    public JLabel  ab       = new JLabel("Account Balance ");
    public JTextField  abtf = new JTextField();

    //  For East
    public JButton     dp   = new JButton ("Deposit");
    public JTextField  dptf = new JTextField();
    public JButton       wt = new JButton ("Withdraw");
    public JTextField  wttf = new JTextField();

    // For South
    public JLabel  status   = new JLabel("");  

    Account account = new Account(1234,1000);  // ******** here *******