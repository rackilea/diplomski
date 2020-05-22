public void AddFileAudio(ActionEvent event) {

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Seleziona il file da caricare");
    fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("Audio Files", "*.wav", "*.mp3"));
    File selectedFile = fileChooser.showOpenDialog(new Stage());        
    if (selectedFile != null) {
        String fileName = selectedFile.getName();
        Table1.getItems().add(new PopulateTable(0, fileName, ""));
    }

}