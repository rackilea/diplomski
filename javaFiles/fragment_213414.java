final JPasswordField pass = new JPasswordField("Password");
    Font passFont = user.getFont();
    pass.setFont(passFont.deriveFont(Font.ITALIC));
    pass.setForeground(Color.GRAY);
    pass.setPreferredSize(new Dimension(150, 20));
    pass.setEchoChar((char)0);
    pass.addFocusListener(new FocusListener() {

        public void focusGained(FocusEvent e) {
            pass.setEchoChar('*');
            if (pass.getText().equals("Password")) {
                pass.setText("");
            }
        }

        public void focusLost(FocusEvent e) {
            if ("".equalsIgnoreCase(pass.getText().trim())) {
                pass.setEchoChar((char)0);
                pass.setText("Password");
            }
        }});