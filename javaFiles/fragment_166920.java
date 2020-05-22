@Override
public void start(Stage primaryStage) {
    // custom hbox with 2 resizeable 
    ShrinkableHBox hbox = new ShrinkableHBox(1);
    hbox.getChildren().addAll(
            new Rectangle(100, 100, Color.RED),
            new Rectangle(100, 100, Color.BLUE)
    );
    hbox.setOpacity(0.5);

    Scene scene = new Scene(new HBox(hbox, new Rectangle(100, 100, Color.GREEN.interpolate(Color.TRANSPARENT, 0.5))));
    primaryStage.setScene(scene);
    primaryStage.show();
}