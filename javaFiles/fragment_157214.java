//Create a file chooser
final JFileChooser fc = new JFileChooser();
//In response to a button click:
int returnVal = fc.showOpenDialog(aComponent);
if (returnVal == JFileChooser.APPROVE_OPTION) { // Success
    // Get filename that was picked
    File file = fc.getSelectedFile();
    //This is where a real application would open the file.
    log.append("Opening: " + file.getName() + "." + newline);
} else { // Cancelled
    log.append("Open command cancelled by user." + newline);
}