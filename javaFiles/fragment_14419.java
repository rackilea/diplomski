Node getChildByRowColumn(final GridPane gridPane, final int row, final int col){

    for(final Node node : gridPane.getChildren()){
        if (GridPane.getRowIndex(node) == null) continue ; //ignore Group 
        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) return node;
    }
    return null;
}