private static <T> TableCell<T, ?> findCell(MouseEvent event, TableView<T> table) {
    Node node = event.getPickResult().getIntersectedNode();

    // go up in node hierarchy until a cell is found or we can be sure no cell was clicked
    while (node != table && !(node instanceof TableCell)) {
        node = node.getParent();
    }
    return node instanceof TableCell ? (TableCell<T, ?>) node : null;
}