@Override
public void start(Stage primaryStage) {
    Region root = new Region();
    root.setBorder(new Border(new BorderStroke(Color.RED, Color.RED, Color.RED, Color.RED,
            BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));

    Scene scene = new Scene(root, 300, 300);

    primaryStage.setScene(scene);
    primaryStage.show();
}