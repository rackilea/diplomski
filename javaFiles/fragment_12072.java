@Override
public void start(Stage primaryStage) {
    Rectangle rect = new Rectangle(50, 50);

    StackPane root = new StackPane(rect);

    rect.addEventFilter(MouseEvent.MOUSE_CLICKED, evt -> {
        System.out.println("rect click(filter)");
//      evt.consume();
    });
    root.addEventFilter(MouseEvent.MOUSE_CLICKED, evt -> {
        System.out.println("root click(filter)");
//        evt.consume();
    });

    root.setOnMouseClicked(evt -> {
        System.out.println("root click(handler)");
//      evt.consume();
    });
    rect.setOnMouseClicked(evt -> {
        System.out.println("rect click(handler)");
//      evt.consume();
    });

    Scene scene = new Scene(root, 200, 200);

    primaryStage.setScene(scene);
    primaryStage.show();
}