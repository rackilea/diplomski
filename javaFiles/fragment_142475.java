public class log extends JFrame{

private JTextField jtfUsername, jtfPassword;
private JButton backButton, loginButton;
private JMenuItem jmiLogin, jmiBack, jmiHelp, jmiAbout;

log() {
    //create menu bar
    JMenuBar jmb = new JMenuBar();

    //set menu bar to the applet
    setJMenuBar(jmb);

    //add menu "operation" to menu bar
    JMenu optionsMenu = new JMenu("Options");
    optionsMenu.setMnemonic('O');
    jmb.add(optionsMenu);

    //add menu "help"
    JMenu helpMenu = new JMenu("Help");
    helpMenu.setMnemonic('H');
    helpMenu.add(jmiAbout = new JMenuItem("About", 'A'));
    jmb.add(helpMenu);

    //add menu items with mnemonics to menu "options"
    optionsMenu.add(jmiLogin = new JMenuItem("Login", 'L'));
    optionsMenu.addSeparator();
    optionsMenu.add(jmiBack = new JMenuItem("Back", 'B'));

    //panel p1 to holds text fields
    JPanel p1 = new JPanel(new GridLayout(2, 2));
    p1.add(new JLabel("Username"));
    p1.add(jtfUsername = new JTextField(15));
    p1.add(new JLabel("Password"));
    p1.add(jtfPassword = new JPasswordField(15));

    //panel p2 to holds buttons
    JPanel p2 = new JPanel(new FlowLayout());
    p2.add(backButton = new JButton("Back"));
    p2.add(loginButton = new JButton("Login"));

    //Panel with image??????

    //add panels to frame
    JPanel panel = new JPanel(new GridLayout(2, 1));
    panel.add(p1, BorderLayout.CENTER);
    panel.add(p2, BorderLayout.SOUTH);
    add(panel, BorderLayout.CENTER);
    setTitle("Main Page");


    //listners for exit menuitem and button
    jmiBack.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Welcome welcome = new Welcome();
            welcome.setVisible(true);
            welcome.setSize(500, 500);
            welcome.setLocationRelativeTo(null);
            registerInterface regFace = new registerInterface();
            regFace.setVisible(false);
            log.this.dispose();
            log.this.setVisible(false); 
        }
    });

    backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Welcome welcome = new Welcome();
            welcome.setVisible(true);
            welcome.setSize(500, 500);
            welcome.setLocationRelativeTo(null);
            registerInterface regFace = new registerInterface();
            regFace.setVisible(false);
            log.this.dispose();
            log.this.setVisible(false);    
        }
    });

    //listner for about menuitem
    jmiAbout.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,
                    "This is the login panel"
                            + "\n Assignment for University",
                    "About", JOptionPane.INFORMATION_MESSAGE);
        }
    });

    //action listeners for Login in button and menu item
    loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try{
            usernamecheck.checkLogin(jtfUsername.getText(),jtfPassword.getText());
            }catch(SQLException se){

            }
            MainMenu mainmenu = new MainMenu();
            mainmenu.setVisible(true);
            mainmenu.setSize(500, 500);
            mainmenu.setLocationRelativeTo(null);
            registerInterface regFace = new registerInterface();
            regFace.setVisible(false);
            log.this.dispose();
            log.this.setVisible(false);     
        }
    });

    jmiLogin.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            MainMenu mainmenu = new MainMenu();
            mainmenu.setVisible(true);
            mainmenu.setSize(500, 500);
            mainmenu.setLocationRelativeTo(null);
            registerInterface regFace = new registerInterface();
            regFace.setVisible(false);
            log.this.dispose();
            log.this.setVisible(false);   
        }
    });
}
public static void main(String arg[])