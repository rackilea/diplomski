Color[] colors = {Color.WHITE, Color.BLACK};

for (int row = 0; row < size; row++) {
    for (int col = 0; col < size; col++) {
        int nextColor = (row + col) % 2;
        Rectangle rec = new Rectangle();
        rec.setWidth(50);
        rec.setHeight(50);
        rec.setFill(colors[nextColor]);
        GridPane.setRowIndex(rec, row);
        GridPane.setColumnIndex(rec, col);
        grid.getChildren().addAll(rec);
    }
}