GridPane root = new GridPane();
    for (int x = 0 ; x < 8; x++) {
        for (int y = 0 ; y < 8 ; y++) {
            Label label = new Label(String.format("Cell [%d, %d]", x, y));
            root.getChildren().add(label);
            GridPane.setColumnIndex(label, x);
            GridPane.setRowIndex(label, y);
        }
    }