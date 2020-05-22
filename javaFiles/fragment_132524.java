public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


            SplitMenuButton splitMenuButton = new SplitMenuButton();
            splitMenuButton.setPrefWidth(400);

            MenuItem menuItem = new MenuItem();
            prepareMenuItem(menuItem, "I am a MenuItem", splitMenuButton);
            Menu menu = new Menu();
            prepareMenuItem(menu, "I am a Menu", splitMenuButton);
            MenuItem subMenuItem = new MenuItem("I am not resized!");
            menu.getItems().add(subMenuItem);

            splitMenuButton.getItems().addAll(menu, menuItem);

            root.setCenter(splitMenuButton);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareMenuItem(MenuItem menuItem, String text, MenuButton menuButton){
        Label label = new Label();
        label.prefWidthProperty().bind(menuButton.widthProperty());
        label.setText(text);
        label.setTextAlignment(TextAlignment.RIGHT);
        menuItem.setGraphic(label);
    }

    public static void main(String[] args) {
        launch(args);
    }
}