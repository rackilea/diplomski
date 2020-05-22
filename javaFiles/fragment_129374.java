@Override
public void start(Stage stage) {
    Group group = new Group();
    Rectangle rect = new Rectangle(0, 0, 350, 300);
    Rectangle clip = new Rectangle(20, 20, 200, 200);
    clip.setArcHeight(15);
    clip.setArcWidth(15);

    Shape shape = Shape.subtract(rect, clip);

    shape.setFill(Color.GRAY);
    group.getChildren().add(shape);
    Scene scene = new Scene(group);
    scene.setFill(Color.TRANSPARENT);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
}