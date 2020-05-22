public class GameCell extends Pane {
    public GameCell() {
        final Circle circle = new Circle(10);
        circle.radiusProperty().bind(Bindings.divide(widthProperty(), 4));

        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(widthProperty().divide(2));

        getChildren().add(circle);
    }
}