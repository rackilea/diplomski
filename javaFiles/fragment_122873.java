public static enum MyFileChooser {

    INSTANCE_FILES(true),
    INSTANCE_DIRS(false);

    private final boolean isFilesOnly;

    private final JFileChooser dynamicChooser;

    private MyFileChooser(boolean filesOnly) {
        this.isFilesOnly = filesOnly;
        this.dynamicChooser = new JFileChooser();
        //dynamicChooser.setControlButtonsAreShown(false);
        this.chooserSetup();
    }

    public void frameSetup(Container parent) {
        // jframe setup code
        parent.add(this.dynamicChooser);
    }

    public void chooserSetup() {
        if (this.isFilesOnly) {
            this.dynamicChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        } else {
            this.dynamicChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        this.dynamicChooser.setMultiSelectionEnabled(true);
        this.dynamicChooser.setDialogType(JFileChooser.CUSTOM_DIALOG);
    }

    public File[] showOpenDialog(Component parent, String title) {
        JDialog dialog = new JDialog(parent == null ? (JDialog)null : SwingUtilities.getWindowAncestor(parent), title);
        dialog.setModal(true);
        frameSetup(dialog);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                //..
                dialog.dispose();
            }
        };
        dynamicChooser.addActionListener(listener);

        dialog.pack();
        dialog.setLocationRelativeTo(parent);

        dialog.setVisible(true);
        dynamicChooser.removeActionListener(listener);

        return dynamicChooser.getSelectedFiles();
    }
}