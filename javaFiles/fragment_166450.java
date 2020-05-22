JFileChooser fileChooser = new JFileChooser();
int returnVal = fileChooserAddDoc.showOpenDialog(fileChooser);
if (returnVal == JFileChooser.APPROVE_OPTION) {
     file = fileChooser.getSelectedFile();
     .
     .
}