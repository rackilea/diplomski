public AdminAddUser extends JInternalFrame {
    private JButton newUserButton;

    public AdminAddUser(GetButtonInterface gbi) {
        newUserButton = gbi.getUserButton();
    }
}