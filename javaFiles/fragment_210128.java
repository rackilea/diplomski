public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            TableView tv = new TableView();
            Pagination pg = new Pagination();

            VBox root = new VBox();
            root.setSpacing(10);
            root.getChildren().addAll( tv, pg);

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}