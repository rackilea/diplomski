int returnVal = fc.showOpenDialog(FileChooserDemo.this);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        String filename = file.getName();
    }