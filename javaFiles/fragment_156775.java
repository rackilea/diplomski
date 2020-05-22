@FXML
public void enfantItemAction() throws IOException {
    // getting the controller class and execute the reload method

    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/Views/Enfant.fxml"));
    Node node = loader.load();

    EnfantController enfantController = loader.getController();
    enfantController.reload();
    borderPane.setCenter(node);
}