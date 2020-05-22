for (int columns = 0; columns < 8; columns++) {
    for (int rows = 0; rows < 8; rows++) {
        positions[columns][rows] = new Button();
        positions[columns][rows].setText("X:" + columns + " Y:" + rows); // current location text (temp)
        positions[columns][rows].setMinHeight(cellDimensions);
        positions[columns][rows].setMaxHeight(cellDimensions);
        positions[columns][rows].setMinWidth(cellDimensions);
        positions[columns][rows].setMaxWidth(cellDimensions);

        String zoneColour = getColourBoard(columns, rows);
        positions[columns][rows].setStyle("-fx-background-color: " + zoneColour + "; ");

        final Button b = positions[columns][rows];
        // final int c = columns, r = rows;
        positions[columns][rows].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // Could use c and r above if needed.
                // positions[c][r]
                b.setStyle("-fx-background-color: #FFA500; ");
            }
        });
        grid.add(positions[columns][rows], columns, rows);
    }
}