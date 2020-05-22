public static void swap(Node n1, Node n2) {
    Integer temp = GridPane.getRowIndex(n1);
    GridPane.setRowIndex(n1, GridPane.getRowIndex(n2));
    GridPane.setRowIndex(n2, temp);

    temp = GridPane.getColumnIndex(n1);
    GridPane.setColumnIndex(n1, GridPane.getColumnIndex(n2));
    GridPane.setColumnIndex(n2, temp);
}