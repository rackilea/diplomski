private void handleNewGameAction(ActionEvent event) throws IOException {

    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

    GridPane pane = (GridPane)fxmlloader.getNamespace().get("topGrid");

    Image image = new Image("x.png");
    pane.add(new ImageView(image), 0, 0);

}