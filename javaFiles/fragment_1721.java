CellType type = map.gridArray[finalCol][finalRow].getValue();
square.getStyleClass().remove(type.getStyleClass());
type = type.inverted();
map.gridArray[finalCol][finalRow].setValue(type);
square.getStyleClass().add(type.getStyleClass());

// are the following lines really necessary?
map.gridArray[finalCol][finalRow].setTier(finalRow);
map.gridArray[finalCol][finalRow].setColumn(finalCol);