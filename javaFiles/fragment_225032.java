//Create a file chooser
    final JFileChooser fc = new JFileChooser();
    int returnVal = fc.showSaveDialog(parentComponent);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
    } else {
        // User canceled the file chooser.
    }