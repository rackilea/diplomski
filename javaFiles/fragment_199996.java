public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);

            Button button = new Button("Open another Stage");
            button.setOnAction(e -> {

                Stage popUpStage = new Stage();

                // Here add the FXML content to the Scene
                Scene popUpScene = new Scene(new Button());
                popUpStage.setScene(popUpScene);

                // Calculate the center position of the parent Stage
                double centerXPosition = primaryStage.getX() + primaryStage.getWidth()/2d;
                double centerYPosition = primaryStage.getY() + primaryStage.getHeight()/2d;

                // Hide the pop-up stage before it is shown and becomes relocated
                popUpStage.setOnShowing(ev -> popUpStage.hide());

                // Relocate the pop-up Stage
                popUpStage.setOnShown(ev -> {
                    popUpStage.setX(centerXPosition - popUpStage.getWidth()/2d);
                    popUpStage.setY(centerYPosition - popUpStage.getHeight()/2d);
                    popUpStage.show();
                });

                popUpStage.showAndWait();
            });

            root.setCenter(button);


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