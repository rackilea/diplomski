@FXML
void mochila (ActionEvent event) throws IOException, SQLException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("mochila.fxml"));
    Parent pane = loader.load();
    anchorPaneContent.getChildren().setAll(pane);
    controladorMochila controller = loader.<controladorMochila>getController();
    controller.getCantidad();
}