@FXML AnchorPane anchorPane;

@FXML
private void RegisterStage() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reg.fxml"));
    Pane registerPane = (Pane) fxmlLoader.load();
    try {
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(registerPane);
    } catch (Exception e) {
        e.printStackTrace();
    }
}