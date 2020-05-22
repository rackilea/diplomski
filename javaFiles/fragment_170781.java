dumpButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            //Get the file
            java.io.File file = fileChooser.getSelectedFile();
            //Create scanner
            try {
                Scanner input = new Scanner(file);
            } catch (FileNotFoundException ex) {
                System.err.println("Error opening " + file.getName());
            }
        }
    }
});