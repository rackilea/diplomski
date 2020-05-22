jTableMemberList = new JTable() {
    public void changeSelection(int rowIndex, int columnIndex, boolean toggle,
                                boolean extend) {
        // Member is being edited and they've clicked on a DIFFERENT row (this
        // method gets called even when the selection isn't actually changing)
        if (editModeIsActive && getSelectedRow() != rowIndex) {
            // User was editing, now they're trying to move away without saving
            Object[] options = {"Save", "Discard", "Cancel"};
            int n = JOptionPane.showOptionDialog(this,
                                            "There are unsaved changes for the "
                                            + "currently selected member.\n\n"
                                            + "Would you like to save them?",
                                            "Save changes?",
                                            JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.WARNING_MESSAGE,
                                            null,
                                            options,
                                            options[0]);

            if (n == JOptionPane.YES_OPTION) {
                saveChanges();
            } else if (n == JOptionPane.NO_OPTION) {
                discardChanges();
            } else {
                // Exit without passing call on to super
                return;
            }
        }

        // make the selection change
        super.changeSelection(rowIndex, columnIndex, toggle, extend);
    }
};