private JTextField getTxtUser() {
    if (txtUser == null) {
        txtUser = new JTextField();
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                getBtnSave().setEnabled(
                    !getTxtUser().getText().isEmpty() &&
                    !getTxtPass().getText().isEmpty());
            }
        });
    }
    return txtUser;
}

private JTextField getTxtPass() {
    if (txtPass == null) {
        txtPass = new JTextField();
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                getBtnSave().setEnabled(
                    !getTxtUser().getText().isEmpty() &&
                    !getTxtPass().getText().isEmpty());
            }
        });
    }
    return txtPass;
}

private JButton getBtnSave() {
    if (btnSave == null) {
        btnSave = new JButton("Save");
        btnSave.setEnabled(false);
    }
}