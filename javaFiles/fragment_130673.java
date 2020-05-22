private void saveFileDialog(){

    fileChooser = new JFileChooser(System.getProperty("employees.dat"));
    disableTextField(fileChooser.getComponents());

    fileChooser.setSelectedFile(new File("employees.dat"));
    fileChooser.setDialogTitle("File to save");

    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        save();
        System.out.println("Save as file: " + fileToSave.getAbsolutePath());
    }
}