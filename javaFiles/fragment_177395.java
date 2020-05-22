import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UnsupportedLookAndFeelException;

public class TestThreadJoin {

    private boolean dbWorkDone = false;
    private boolean credentialsProvided = false;
    private JTextField loginTF;
    private JTextField passwordTF;

    protected void initUI() {
        final JFrame frame = new JFrame(TestThreadJoin.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel login = new JLabel("Login: ");
        JLabel password = new JLabel("Password: ");
        loginTF = new JTextField(20);
        passwordTF = new JPasswordField(20);
        GridBagConstraints gbc = new GridBagConstraints();
        panel.add(login, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(loginTF, gbc);
        gbc.gridwidth = 1;
        panel.add(password, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(passwordTF, gbc);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                credentialsProvided = true;
                proceed();
            }
        });
        frame.add(panel);
        frame.add(loginButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(10000);
                return null;
            }

            @Override
            protected void done() {
                super.done();
                dbWorkDone = true;
                proceed();
            }
        };
        worker.execute();
    }

    protected void proceed() {
        if (credentialsProvided && dbWorkDone) {
            System.err.println("Continuing ");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestThreadJoin().initUI();
            }
        });
    }
}