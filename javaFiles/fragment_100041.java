package stackoverflow;

import java.awt.EventQueue;

public class Login {

    private JFrame frame;
    private JTextField txtusername;
    private JPasswordField txtPassword;
    private JButton btnPlaceorder;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 341, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(21, 56, 52, 14);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(21, 94, 52, 14);
        frame.getContentPane().add(lblPassword);

        txtusername = new JTextField();
        txtusername.setBounds(83, 53, 86, 20);
        frame.getContentPane().add(txtusername);
        txtusername.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(83, 91, 86, 20);
        frame.getContentPane().add(txtPassword);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtusername.getText().equals("admin") && new String(txtPassword.getPassword()).equals("admin")) {
                    btnPlaceorder.setEnabled(true);
                } else {
                    btnPlaceorder.setEnabled(false);
                }
            }
        });
        btnNewButton.setBounds(10, 138, 89, 23);
        frame.getContentPane().add(btnNewButton);

        btnPlaceorder = new JButton("PlaceOrder");
        btnPlaceorder.setEnabled(false);
        btnPlaceorder.setBounds(105, 138, 89, 23);
        frame.getContentPane().add(btnPlaceorder);
    }
}