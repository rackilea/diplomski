JFileChooser fileChooser = new JFileChooser();
FileFilter filter = new FileNameExtensionFilter("Files", ".xlsx");
fileChooser.addChoosableFileFilter(filter);
fileChooser.setAcceptAllFileFilterUsed(false);
fileChooser.setDialogTitle("Save the dictionary file"); 
fileChooser.setSelectedFile(new File(fileDictName));
int userSelection = fileChooser.showSaveDialog(fileChooser);
if (userSelection == JFileChooser.APPROVE_OPTION) {
    fileDictName = fileChooser.getSelectedFile().getAbsolutePath();
}