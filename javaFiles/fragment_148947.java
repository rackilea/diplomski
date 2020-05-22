public class LoginForm {

    public static void main(String[] args) {
        new LoginForm();
    }

    public LoginForm() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JDialog frame = new JDialog((JFrame) null, "Login", true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new LoginPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                System.exit(0);
            }
        });
    }

    public class LoginPane extends JPanel {

        private JTextField userNameField;
        private JPasswordField passwordField;
        private JButton okay;
        private JButton cancel;

        public LoginPane() {

            setLayout(new BorderLayout());

            userNameField = new JTextField(15);
            passwordField = new JPasswordField(10);

            okay = new JButton("Login");
            cancel = new JButton("Cancel");

            JPanel mainPane = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new Insets(2, 2, 2, 2);
            mainPane.add(new JLabel("User Name:"), gbc);
            gbc.gridy++;
            mainPane.add(new JLabel("Password:"), gbc);

            gbc.gridx++;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            mainPane.add(userNameField, gbc);
            gbc.gridy++;
            mainPane.add(passwordField, gbc);
            mainPane.setBorder(new EmptyBorder(8, 8, 8, 8));

            add(mainPane);

            JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPane.setBorder(new EmptyBorder(8, 8, 8, 8));
            buttonPane.add(okay);
            buttonPane.add(cancel);

            add(buttonPane, BorderLayout.SOUTH);

            okay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    userNameField.setEnabled(false);
                    passwordField.setEnabled(false);
                    okay.setEnabled(false);
                    cancel.setEnabled(false);
                    new LoginWorker(userNameField.getText(), passwordField.getPassword()).execute();
                }
            });

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.getWindowAncestor(LoginPane.this).dispose();
                }
            });
        }

        public class LoginWorker extends SwingWorker<Boolean, Boolean> {

            private String userName;
            private char[] password;

            public LoginWorker(String userName, char[] password) {
                this.userName = userName;
                this.password = password;
            }

            @Override
            protected Boolean doInBackground() throws Exception {
                // Do you background work here, query the database, compare the values...
                Thread.sleep(2000);
                return Math.round((Math.random() * 1)) == 0 ? new Boolean(true) : new Boolean(false);
            }

            @Override
            protected void done() {
                System.out.println("Done...");
                try {
                    if (get()) {
                        JOptionPane.showMessageDialog(LoginPane.this, "Login sucessful");
                    } else {
                        JOptionPane.showMessageDialog(LoginPane.this, "Login failed");
                    }
                    userNameField.setEnabled(true);
                    passwordField.setEnabled(true);
                    okay.setEnabled(true);
                    cancel.setEnabled(true);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }

        }

    }
}