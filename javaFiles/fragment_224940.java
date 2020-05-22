class CloseSomeDialogListener implements ActionListener {
    private MainGui mainGui;

    public CloseSomeDialogListener(MainGui mainGui) {
        this.mainGui = mainGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainGui.closeSomeDialog();
    }
}