public Pane getPane() {
  GridPane grid = new GridPane();
  grid.setGridLinesVisible(true);
  grid.setVgap(8);
  grid.setHgap(8);

  Button btn = new Button("button");
  grid.add(btn, 5, 5);

  return grid;
}