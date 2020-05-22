loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
loginPanel.add(login);

login.setFocusable(false);

loginPanel.addKeyListener(pleaseWait);
admin.addKeyListener(pleaseWait);
admin.setContentPane(loginPanel);
admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
admin.setBounds(0, 0, 200, 200);
admin.setVisible(true);