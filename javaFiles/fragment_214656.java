@Override
public void start(Stage primaryStage) {
    ListView<Integer> listView = new ListView<>();
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    listView.getItems().setAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    listView.addEventFilter(MouseEvent.MOUSE_PRESSED, evt -> {
        Node node = evt.getPickResult().getIntersectedNode();

        // go up from the target node until a list cell is found or it's clear
        // it was not a cell that was clicked
        while (node != null && node != listView && !(node instanceof ListCell)) {
            node = node.getParent();
        }

        // if is part of a cell or the cell,
        // handle event instead of using standard handling
        if (node instanceof ListCell) {
            // prevent further handling
            evt.consume();

            ListCell cell = (ListCell) node;
            ListView lv = cell.getListView();

            // focus the listview
            lv.requestFocus();

            if (!cell.isEmpty()) {
                // handle selection for non-empty cells
                int index = cell.getIndex();
                if (cell.isSelected()) {
                    lv.getSelectionModel().clearSelection(index);
                } else {
                    lv.getSelectionModel().select(index);
                }
            }
        }
    });

    Scene scene = new Scene(listView);

    primaryStage.setScene(scene);
    primaryStage.show();
}