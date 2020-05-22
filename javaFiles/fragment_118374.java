class OpenListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.showOpenDialog(gui);
        if (fileOpen.getSelectedFile() != null) {
            model = readModel(fileOpen.getSelectedFile());
            if (model != null) {
                // Do stuff with model object of SimulationModel class.
            }
        }           
    }

    private static SimulationModel readModel(File file) {
        SimulationModel modelObject = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            modelObject = (SimulationModel) ois.readObject();
            consolePanel.printToConsole("File opened.\n\n");                
        } catch (IOException | ClassNotFoundException ex) {
            consolePanel.printToConsole("Error during file opening.\n\n");
        }
        return modelObject;
    }
}