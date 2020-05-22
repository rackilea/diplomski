public class MyFileChooser {

    private final boolean isFilesOnly;
    private static final MyFileChooser INSTANCE_FILES = new MyFileChooser(true);
    private static final MyFileChooser INSTANCE_DIRS = new MyFileChooser(false);

    private final JFileChooser dynamicChooser;

    private MyFileChooser(boolean filesOnly) {
        this.isFilesOnly = filesOnly;
        this.dynamicChooser = new JFileChooser();
        dynamicChooser.setControlButtonsAreShown(false);
        this.chooserSetup();
    }

    public MyFileChooser getInstance(boolean filesOnly) {
        if (filesOnly) {
            return MyFileChooser.INSTANCE_FILES;
        } else {
            return MyFileChooser.INSTANCE_DIRS;
        }
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
        JDialog dialog = new JDialog(parent == null ? null : SwingUtilities.getWindowAncestor(parent), title);
        dialog.setModal(true);
        frameSetup(dialog);

        dialog.pack();
        dialog.setLocationRelativeTo(parent);

        dialog.setVisible(true);

        return dynamicChooser.getSelectedFiles();
    }
}