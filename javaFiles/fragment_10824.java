jbtOk.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        List<User> users = new Users().getUsers();
        for (User u : users) {
            if (Arrays.equals(u.getPassword().toCharArray(), jpfPassword.getPassword())
                    && u.getUser().equals(jtfUsername.getText())) {
                user = u;
                dispose();
                break;
            } else {
                jlblStatus.setText("Invalid username or password");
            }
        }
    }
});