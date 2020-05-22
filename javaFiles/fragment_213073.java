public class Real_estate extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image("http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/house-icon.png"));
        stage.setTitle("Simple program 0.8");
        stage.setWidth(300);
        stage.setHeight(300);
        stage.setResizable(false);

        HtmlSearch htmlSearch = new HtmlSearch ();
        new Thread(() -> htmlSearch.toDatabase("http://example.com")).start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}