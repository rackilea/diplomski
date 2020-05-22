/*-- file: Application.java --*/
import javax.swing.JOptionPane;

/**
 *
 * @author danLeon
 */
interface LoginModel {

    String getUser();

    void setUser(String user);
}

class MyLoginModel implements LoginModel {

    String user;

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }
}

interface LoginView {

    LoginPresenter getPresenter();

    void setPresenter(LoginPresenter loginPresenter);

    void updateModelFromView();

    void updateViewFromModel();

    void open();

    void close();

    void userRejected();
}

class MyLoginView extends javax.swing.JFrame implements LoginView {

    private LoginPresenter loginPresenter;

    /**
     * Creates new form MyLoginView
     */
    public MyLoginView() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 7, 0};
        layout.rowHeights = new int[] {0, 7, 0, 7, 0};
        getContentPane().setLayout(layout);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Welcome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jLabel1, gridBagConstraints);

        jTextField1.setColumns(13);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jTextField1, gridBagConstraints);

        jLabel2.setText("User");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jLabel2, gridBagConstraints);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jButton1, gridBagConstraints);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        getPresenter().login();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;


    @Override
    public void updateModelFromView() {
        getPresenter().getModel().setUser(jTextField1.getText());
    }

    @Override
    public void updateViewFromModel() {
        jTextField1.setText(getPresenter().getModel().getUser());
    }

    @Override
    public void open() {
        setVisible(true);
        jTextField1.selectAll();
        jTextField1.requestFocus();
    }

    @Override
    public void close() {
        dispose();
    }

    @Override
    public void userRejected() {
        jLabel1.setText("Try again!");
        jTextField1.selectAll();
        jTextField1.requestFocus();
    }

    @Override
    public LoginPresenter getPresenter() {
        return loginPresenter;
    }

    @Override
    public void setPresenter(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }
}

interface LoginPresenter {

    LoginModel getModel();

    void setModel(LoginModel loginModel);

    LoginView getView();

    void setView(LoginView loginView);

    void setOnLogin(Runnable onLogin);

    void run();

    void login();
}

class MyLoginPresenter implements LoginPresenter {

    LoginModel loginModel;
    LoginView loginView;
    private Runnable onLogin;

    @Override
    public LoginModel getModel() {
        return loginModel;
    }

    @Override
    public void setModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    @Override
    public LoginView getView() {
        return loginView;
    }

    @Override
    public void setView(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void setOnLogin(Runnable onLogin) {
        this.onLogin = onLogin;
    }

    @Override
    public void run() {
        loginModel.setUser("previousUser");
        loginView.setPresenter(this);
        loginView.updateViewFromModel();
        loginView.open();
    }

    @Override
    public void login() {
        loginView.updateModelFromView();
        if (loginModel.getUser().equalsIgnoreCase("root")) {
            loginView.close();
            loginView.setPresenter(null);// for memory sanity. 
            onLogin.run();
        } else {
            loginView.userRejected();
        }
    }
}

public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LoginModel loginModel = new MyLoginModel();
                LoginPresenter loginPresenter = new MyLoginPresenter();
                loginPresenter.setModel(loginModel);
                LoginView loginView = new MyLoginView();
                loginPresenter.setView(loginView);
                loginPresenter.setOnLogin(new Runnable() {

                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(null, "Welcome user!");
                    }
                });
                loginPresenter.run();
            }
        });
    }
}