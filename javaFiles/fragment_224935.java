public class ShowDialogListener implements ActionListener {
    private MainGui mainGui;

    public ShowDialogListener(MainGui mainGui) {
        // pass the main GUI reference into the listener
        this.mainGui = mainGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // tell the main GUI to display the dialog
        mainGui.displaySomeDialog();
    }
}