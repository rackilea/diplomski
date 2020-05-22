@FXML
    private BorderPane borderPane;
@FXML
    private AnchorPane anchorPane;

private void changeScreenOfCenter(String path, VBox menuVBox) {
        VBox getVbox = menuVBox;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource(path));
        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            System.out.println(e.getMessage());
        }
}