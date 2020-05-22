@FXML
private void handleSourceBrowse(ActionEvent ae) {
    Node source = (Node) ae.getSource();
    Window theStage = source.getScene().getWindow();

    sourceDirectoryChooser.showDialog(theStage);
}