public void start(Stage primaryStage) {

  GridPane pane = new GridPane();
  MatrixPane Matrix = new MatrixPane();
  //pane.getChildren().add(Matrix);
  Matrix.fillmatrix();
  Scene scene = new Scene(Matrix.getPane1(), 700, 500);
  ...