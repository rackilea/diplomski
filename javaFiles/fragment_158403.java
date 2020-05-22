JFileChooser chooser = new JFileChooser();
FileNameExtensionFilter filter = new FileNameExtensionFilter(
    "JPG & GIF Images", "jpg", "gif");
chooser.setFileFilter(filter);
chooser.setDialogTitle("Add new file");
int returnVal = chooser.showOpenDialog(parent);