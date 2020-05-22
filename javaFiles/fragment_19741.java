public File openFile(/*no argument here*/){
    File fileToOpen; // Local variable

    final JFileChooser fileChooser = new JFileChooser();
    int modalToComponent=fileChooser.showOpenDialog(this);
    if (modalToComponent == JFileChooser.APPROVE_OPTION) {
        fileToOpen = fileChooser.getSelectedFile();         
    }

    return fileToOpen;

}