if (currentFile == null) {

    JFileChooser fc = new JFileChooser();
    int resp = fc.showSaveDialog(fc);

    if (resp == JFileChooser.APPROVE_OPTION) {
        currentFile = fc.getSelectedFile();
    }

}

// Used to make sure that the user didn't cancel the JFileChooser
if (currentFile != null) {
    PrintStream fileOut = null;
    try {
        fileOut = new PrintStream(file);
        fileOut.print(txtArea.getText());
    } catch (IOException ex) {
        Logger.getLogger(frmNotePad.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            fileOut.close();
        } catch (IOException exp) {
        }
    }