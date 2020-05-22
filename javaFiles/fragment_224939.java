class ShowDialogListener implements ActionListener {
    private MainGui mainGui;

    public ShowDialogListener(MainGui mainGui) {
        this.mainGui = mainGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainGui.displaySomeDialog();
    }
}