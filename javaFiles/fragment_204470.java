public static MyOption showMyDialog() {
    final JDialog myDialog = new JDialog();
    myDialog.add(myPanel);
    myDialog.setModal(true);
    myDialog.setVisible(true); // blocker since the dialog is modal

    return myPanel.getSelectedOption();
}