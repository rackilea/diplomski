public void actionPerformed(ActionEvent arg0) {
    initLoadingPanel();
    csv = FileReaderCSVHelper.fileReader(dirName.getText(), fileName.getText());
    generateTableList(csv.getCsvTitle(), stateController.getFieldNames());
    loader.dispose();
}