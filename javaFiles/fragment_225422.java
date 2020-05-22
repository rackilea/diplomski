JFileChooser chooser = new JFileChooser() {
    @Override
    public void approveSelection() {
        File selectedFile = getSelectedFile();
        if (selectedFile != null && ShellFolder.isComputerNode(selectedFile)) {
            try {
                // Resolve path and try to navigate to it
                setCurrentDirectory(getComputerNodeFolder(selectedFile.getPath()));
            } catch (FileNotFoundException ex) {
                // Alert user if given computer node cannot be accessed
                JOptionPane.showMessageDialog(this, "Cannot access " + selectedFile.getPath());
            }
        } else {
            super.approveSelection();
        }
    }
};
chooser.showOpenDialog(null);