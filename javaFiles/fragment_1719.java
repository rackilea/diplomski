for (int col = 0; col < 20; col++) {
    for (int row = 0; row < 20; row++) {
        Label square = new Label();
        if (map.gridArray[col][row].getValue() == ' ') {
            square.getStyleClass().add("default-box");
        } else if (map.gridArray[col][row].getValue() == 'S') {
            square.setText("Start");
            square.getStyleClass().add("start-end");
        } else if (map.gridArray[col][row].getValue() == 'E') {
            square.setText("End");
            square.getStyleClass().add("start-end");
        } else {
            square.getStyleClass().add("wall");
        }
        labelGridArray[col][row] = square;
        grid.add(square, col, row);
    }
}
for (int col = 1; col < 19; col++) {
    final int finalCol = col; // copy accessible from handler
    for (int row = 1; row < 19; row++) {
        final int finalRow = row; // copy accessible from handler
        final Label square = labelGridArray[col][row];
        square.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
               if (map.gridArray[finalCol][finalRow].getValue() == 'W'){
                    square.getStyleClass().remove("wall");
                    square.getStyleClass().add("default-box");
                    map.gridArray[finalCol][finalRow].setTier(finalRow); 
                    map.gridArray[finalCol][finalRow].setColumn(finalCol);
                    map.gridArray[finalCol][finalRow].setValue(' ');
                } else {
                    square.getStyleClass().remove("default-box");
                    square.getStyleClass().add("wall");
                    map.gridArray[finalCol][finalRow].setTier(finalRow); 
                    map.gridArray[finalCol][finalRow].setColumn(finalCol);
                    map.gridArray[finalCol][finalRow].setValue('W');
                }
            }
        });
    }
}