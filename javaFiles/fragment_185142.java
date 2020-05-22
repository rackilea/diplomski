public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    Polygon polygon = new Polygon();
    polygon.setFill(javafx.scene.paint.Color.RED); //sets the color of polygon
    ObservableList<Double> list = polygon.getPoints();

    //create a label to display in the middle of the "stop sign" polygon shape
    //This is what I need most help on
    Label sign = new Label("STOP");
    //sign.setStyle("-fx-text-fill: white; -fx-font-size: 3em");
    sign.setAlignment(Pos.CENTER);
    System.out.print(sign);


    pane.getChildren().add(polygon);
    pane.getChildren().add(sign);

    final double WIDTH = 200, HEIGHT = 200;
    double centerX = WIDTH / 2, centerY = HEIGHT / 2;
    double radius = Math.min(WIDTH, HEIGHT) * 0.4;

    // Add points to the polygon list
    for (int i = 0; i < 6; i++) {
        list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
        list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
    }

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("ShowPolygon"); //Set the stage title
    primaryStage.setScene(scene); //Place the scene in the stage
    primaryStage.show(); //Display the stage


}