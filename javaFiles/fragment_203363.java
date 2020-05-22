public class Transitions extends Application {
public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage stage) throws Exception {
    Rectangle circle1 = RectangleBuilder.create()
            .arcHeight(300)
            .arcWidth(300)
            .height(30)
            .width(40)
            .opacity(0.6)
            .translateY(30)
            .style("-fx-fill: linear-gradient(#82d24f,#398907); -fx-stroke: #4a4a4a; -fx-stroke-width: 2")
            .build();

    Rectangle circle2 = RectangleBuilder.create()
            .arcHeight(300)
            .arcWidth(300)
            .height(40)
            .width(50)
            .opacity(0.7)
            .translateX(10)
            .translateY(70)
            .style("-fx-fill: linear-gradient(#82d24f,#398907); -fx-stroke: #4a4a4a; -fx-stroke-width: 2.5")
            .build();

    FadeTransition fade1 = FadeTransitionBuilder.create()
            .duration(Duration.millis(200))
            .node(circle1)
            .toValue(0.3)
            .cycleCount(2)
            .autoReverse(true)
            .build();

    FadeTransition fade2 = FadeTransitionBuilder.create()
            .duration(Duration.millis(100))
            .node(circle2)
            .toValue(0.3)
            .cycleCount(2)
            .autoReverse(true)
            .build();

    SequentialTransition ChildBalloonFade = SequentialTransitionBuilder.create()
            .children(fade1,fade2)
            .cycleCount(Timeline.INDEFINITE)
            .build();

    final ToggleButton button = new ToggleButton("Stop");

    fade2.setOnFinished(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (button.isSelected()) {
                ChildBalloonFade.stop();
            }
        }
    });

    button.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if (!button.isSelected()) {
                ChildBalloonFade.play();
            }
        }
    });

    VBox vBox = new VBox();
    vBox.getChildren().addAll(circle1, circle2, button);
    stage.setScene(new Scene(vBox));
    stage.show();
    ChildBalloonFade.play();
}}