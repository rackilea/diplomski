@Override
public void start(Stage primaryStage) throws Exception {
    GridPane grid = new GridPane();
    CheckBox box1 = new CheckBox("horse");
    box1.setMinWidth(200);
    box1.setAlignment(Pos.CENTER_RIGHT);
    grid.getChildren().add(box1);
    CheckBox box2 = new CheckBox("banana");
    grid.getChildren().add(box2);
    GridPane.setRowIndex(box2, 1);
    GridPane.setHalignment(box2, HPos.RIGHT);   // <=== this is probably what you want
    primaryStage.setScene(new Scene(grid));
    primaryStage.show();
}