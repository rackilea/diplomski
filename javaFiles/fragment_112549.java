public Login(App app) {
    logInButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           app.changeFocus(1);
        }
    });
}