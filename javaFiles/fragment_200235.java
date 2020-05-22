public static String selectFolder() {
    final JFileChooser chooser = new JFileChooser() {
        public void approveSelection() {
            if (getSelectedFile().isFile()) {
                return;
            } else
                super.approveSelection();
        }
    };

    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("Select Folder");
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    chooser.setAcceptAllFileFilterUsed(true);

    chooser.setSelectedFile(new java.io.File("."));
    chooser.showOpenDialog(null);
    File x = chooser.getSelectedFile();

    if (x != null)
        return x.toString();

    return null;
}