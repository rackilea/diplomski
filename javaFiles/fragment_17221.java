@Override
public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Experiment");

    Button button2 = new Button("Expand");
    Button button3 = new Button("Button 3");
    Button button4 = new Button("Button 4");

    GridPane gridPane = new GridPane();

    ToolBar bar = new ToolBar();
    bar.getItems().addAll(button3, button4);
    bar.setTranslateX(-10000); // somewhere outside view

    gridPane.add(button2, 0, 0, 1, 1);
    gridPane.add(bar, 1, 0, 1, 1);

    TranslateTransition transition = new TranslateTransition(Duration.millis(300), bar);
    transition.setToX(0);

    EventHandler<MouseEvent> enterHandler = (MouseEvent event) -> {
        transition.setFromX(-gridPane.getWidth());
        Duration time = transition.getCurrentTime();
        transition.setRate(1);
        transition.playFrom(time);
    };

    EventHandler<MouseEvent> exitHandler = (MouseEvent event) -> {
        if (!(button2.isHover() || bar.isHover())) {
            Duration time = transition.getCurrentTime();
            transition.setRate(-1);
            transition.playFrom(time);
        }
    };

    //Handle Mouse on Button
    button2.setOnMouseEntered(enterHandler);
    bar.setOnMouseEntered(enterHandler);
    button2.setOnMouseExited(exitHandler);
    bar.setOnMouseExited(exitHandler);


    Scene scene = new Scene(gridPane, 240, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
}