public void start(final Stage stage) throws Exception {
  final Button button0 = new Button("Start learning");
  final Button button1 = new Button("Customize");

  final GridPane cPane = new GridPane();
  cPane.getChildren().addAll(button0, button1);
  GridPane.setConstraints(button0, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER);
  GridPane.setConstraints(button1, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER);

  final ColumnConstraints columnn0 = new ColumnConstraints();
  columnn0.setPercentWidth(100);
  cPane.getColumnConstraints().addAll(columnn0);

  final RowConstraints row0 = new RowConstraints(1);
  row0.setPercentHeight(50);

  final RowConstraints row1 = new RowConstraints(1);
  row1.setPercentHeight(50);

  cPane.getRowConstraints().addAll(row0, row1);

  stage.setScene(new Scene(cPane));
  stage.setWidth(200);
  stage.setHeight(100);
  stage.show();
}