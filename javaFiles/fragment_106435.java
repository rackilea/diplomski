public class AnchorDemo extends Application {

    private final Button button = new Button("Add");
    private final ListView list = new ListView();

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(list, 10.0);
        AnchorPane.setLeftAnchor(list, 10.0);
        AnchorPane.setTopAnchor(button, 10.0);
        AnchorPane.setRightAnchor(button, 10.0);
        root.getChildren().addAll(list, button);

        Scene scene = new Scene(root, 300, 250);

        scene.widthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                updateWidthConstaints(newValue.doubleValue());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        updateWidthConstaints(scene.getWidth());
    }

    private void updateWidthConstaints(double width) {
        // roughly give to the list 66% while to the button 33% of available
        // space, besides paddings.
        // +5s are for extra padding
        AnchorPane.setRightAnchor(list, width * 1 / 3 + 5);
        AnchorPane.setLeftAnchor(button, width * 2 / 3 + 5);
    }

    public static void main(String[] args) {
        launch(args);
    }

}