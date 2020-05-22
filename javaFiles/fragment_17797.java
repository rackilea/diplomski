public void someMethod(String savedName) {
    // The commented-out code that used to ask for a filename.
    // if (OperatingSystem.isMacOSX()) {
    //     savedName = showFileDialog(parentView, dialogTitle, contentType, name, true);
    // } else {
    //     savedName = showFileChooser(parentView, dialogTitle, contentType, name, true);
    // }

    // Rest of method stays the same.
    File f = new File(savedName);
    // etc.
}