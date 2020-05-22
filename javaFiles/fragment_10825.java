public MainFrame() {
    initComponents();
    passDialog = new LoginDialog(this, true);
    passDialog.setVisible(true);
    User user = passDialog.getUser();
}