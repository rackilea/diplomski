public AdminAddUser extends JInternalFrame {
    private JButton newUserButton;

    public AdminAddUser(GetButtonInterface gbi) {
        newUserButton = gbi.getUserButton();

        addInternalFrameListener(new InternalFrameAdapter(){
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                newUserButton.setEnabled(true);
            }
        });
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        dispose();
        newUserButton.setEnabled(true);
    }
}