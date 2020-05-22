if (command.equals("Quit")) {
    // Close application
} else if (command.equals("Open")) {
    JFileChooser fileChooser = new JFileChooser(); 
    int returnVal = fileChooser.showOpenDialog(parent);

    if (returnVal ==  FileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        // Load file
    } else if (returnVal == JFileChooser.CANCEL_OPTION ) {
        // Do something else
    } 
} else if (command.equals("Save")) {
    // Save menu item action
}