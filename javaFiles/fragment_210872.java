@FXML
void mochila (ActionEvent event) throws IOException, SQLException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("mochila.fxml"));
    anchorPaneContent.getChildren().setAll(loader.load());
    controladorMochila controller = loader.<controladorMochila>getController();
    controller.getCantidad();
}