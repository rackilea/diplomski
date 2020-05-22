private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
System.out.println("Gridpane: " + gridPane.getChildren().toString());
for (Node node : gridPane.getChildren()) {
    System.out.println("Node: " + node.toString());
    if (GridPane.getColumnIndex(node) != null && GridPane.getRowIndex(node) != null &&
        GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
        return node;
    }
}
return null;}