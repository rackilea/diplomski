JFileChooser jfc = new JFileChooser();
jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
jfc.setCurrentDirectory(new File("C:/"));
if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    File selectedFile = jfc.getSelectedFile();
    File[] listOfFiles = selectedFile.listFiles();
}