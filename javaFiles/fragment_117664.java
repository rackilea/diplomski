public class LoginView extends JFrame implements ActionListener {

    private static final long serialVersionUID = -7284396337557548747L;
    private JTextField nameTxt = new JTextField(10);
    private JTextField passwordTxt = new JTextField(10);
    private JButton loginBtn = new JButton("Giriş");

    public LoginView() {
        JPanel loginPanel = new JPanel();

        this.setSize(600,200);
        this.setLocation(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginBtn.setBounds(200, 270, 100, 50);

        loginPanel.add(nameTxt);
        loginPanel.add(passwordTxt);
        loginPanel.add(loginBtn);

        this.add(loginPanel);
        this.setVisible(true);
        loginBtn.addActionListener(this);
    }

    public String getName() {
        return nameTxt.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(getName());
    }
}