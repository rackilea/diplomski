JFileChooser openFileChooser = new JFileChooser();
openFileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
openFileChooser.showOpenDialog(null);
openFileChooser.setCurrentDirectory(new File("."));
if (openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
   input = new ObjectInputStream(new FileInputStream(openFileChooser.getSelectedFile()));
   input.close();
}