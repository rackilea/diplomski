bgPanel.setLayout(new BorderLayout());
 // --------- your other code
 t.setLayout(null);
 //--------------- your other code
 t.setContentPane(bgPanel); // you are setting bgPanel which has BorderLayout
 JButton registerButton = new JButton("register");
 registerButton.setBounds(80, 80, 80, 80);
 t.add(registerButton); // t is the JFrame, your main window