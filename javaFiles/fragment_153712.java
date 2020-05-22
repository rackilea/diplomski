public void start(final Stage stage) throws Exception {
    final Button button0 = new Button("Start learning");
    final Button button1 = new Button("Customize");

    final VBox box = new VBox();
    box.setFillWidth(true);

    box.getChildren().setAll(button0, button1);
    box.setAlignment(Pos.CENTER);

    stage.setScene(new Scene(box));
    stage.setWidth(200);
    stage.setHeight(100);
    stage.show();
}