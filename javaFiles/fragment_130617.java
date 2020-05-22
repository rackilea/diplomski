public Scene MainScreen(Stage stage) {
    final Group root = new Group();

    Scene scene = new Scene(root, getX(), getY());
    scene.setFill(Color.WHITE);

    Pane Start = UI_Button("Start", new int[] { getX() * 3 / 4, 0 }, new int[] { getX() / 4, getY() / 4 }, Color.RED);
    Pane Calibration = UI_Button("Callibration", new int[] { 0, 0 }, new int[] { getX() / 2, getY() / 4 }, Color.rgb(60, 208, 230));

    System.out.println(Calibration.boundsInLocalProperty());
    root.getChildren().addAll(Calibration, Start);

    final Timeline Main_Button_Animation = new Timeline(
            new KeyFrame(Duration.ZERO,
                    new KeyValue(Calibration.translateXProperty(), 0),
                    new KeyValue(Start.translateXProperty(), 0)),
            new KeyFrame(Duration.millis(500),
                    new KeyValue(Calibration.translateXProperty(), getX() / 2),
                    new KeyValue(Start.translateXProperty(), -getX() / 4)));

    Main_Button_Animation.setRate(-1);
    Main_Button_Animation.playFrom(Main_Button_Animation.getTotalDuration());

    Calibration.setOnMouseClicked(MouseEvent -> {
        Calibration.setDisable(true);
        Start.setDisable(true);
        System.out.println(Calibration.boundsInLocalProperty());
        Main_Button_Animation.playFromStart();
        Main_Button_Animation.setOnFinished(event -> {
            this.initiater.Calibration_Pressed();
            System.out.println("done");
        });
    });
    this.initiater.Back_Listener(() -> {
        Main_Button_Animation.setRate(-1);
        Main_Button_Animation.playFrom(Main_Button_Animation.getTotalDuration());
        Main_Button_Animation.setOnFinished(e -> {
            Calibration.setDisable(false);
            Start.setDisable(false);
        });
    });
    return scene;
}