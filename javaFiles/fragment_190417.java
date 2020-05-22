private JCheckBox getCbChildrenY() {
    if (cbChildrenY == null) {
        cbChildrenY = new JCheckBox("Children (Y)");
        cbChildrenY.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                showMansions();
                handleTxKids();
            }
        });
        cbChildrenY.setSelected(true);
    }
    return cbChildrenY;
}
private JCheckBox getCbChildrenN() {
    if (cbChildrenN == null) {
        cbChildrenN = new JCheckBox("Children (N)");
        cbChildrenN.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                showMansions();
                handleTxKids();
            }
        });
        cbChildrenN.setSelected(true);
    }
    return cbChildrenN;
}

private JTextField getTxKids() {
    if (txKids == null) {
        txKids = new JTextField();
        txKids.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //do something.
            });
        txKids.setColumns(10);
        txKids.setBounds(203, 350, 78, 20);
    }
    return txKids;
}
private void handleTxKids() {
    if ((getCbChildrenN().isSelected() == true) && (getCbChildrenY().isSelected() == false)){
        getTxKids().setEnabled(false);
   } else {
        getTxKids().setEnabled(true);
   }
}