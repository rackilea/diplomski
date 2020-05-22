@FXML
private void handleButtonAction(ActionEvent event) {
    try {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_second.fxml"));
        Fxml_secondController cont = new Fxml_secondController();
        cont.setFlag(0x00000002);
        cont.setIsChange(false);
        loader.setController(cont);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }
}