@Override
public void start(Stage primaryStage) {
    Pane root = new Pane();
    root.setPrefSize(400, 300);
    Text text = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit."
            + " Nullam vehicula justo et sem venenatis mattis non ut quam. "
            + "Aliquam erat volutpat. Etiam maximus magna quis tortor "
            + "pellentesque, in sollicitudin odio ullamcorper. Phasellus "
            + "a quam nisl. Fusce at urna dapibus, elementum quam "
            + "ultricies, posuere ipsum. Etiam varius orci a tortor "
            + "vestibulum fringilla. Sed consectetur nunc rhoncus diam "
            + "volutpat, vitae finibus eros cursus. Praesent quam mauris, "
            + "lacinia nec metus vitae, blandit faucibus tortor.");

    text.setWrappingWidth(385);
    text.setLayoutX(15);
    text.setLayoutY(20);

    VBox menu = new VBox();
    menu.setId("menu");
    menu.prefHeightProperty().bind(root.heightProperty());
    menu.setPrefWidth(200);

    menu.getChildren().addAll(new Button("Something"), new Button("Something else"), new Button("Something different"));

    menu.getStylesheets().add(getClass().getResource("menustyle.css").toExternalForm());
    menu.setTranslateX(-190);
    TranslateTransition menuTranslation = new TranslateTransition(Duration.millis(500), menu);

    menuTranslation.setFromX(-190);
    menuTranslation.setToX(0);

    menu.setOnMouseEntered(evt -> {
        menuTranslation.setRate(1);
        menuTranslation.play();
    });
    menu.setOnMouseExited(evt -> {
        menuTranslation.setRate(-1);
        menuTranslation.play();
    });

    root.getChildren().addAll(text, menu);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}