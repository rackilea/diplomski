private File selectedFile;
//...
selectedFile = null;
JFileChooser FileChooser = new JFileChooser();
if (FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    selectedFile = FileChooser.getSelectedFile();
    String path= f.getAbsolutePath();
    textField.setText(path);
}