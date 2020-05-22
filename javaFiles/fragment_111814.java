listViewLeft.getSelectionModel().getSelectedIndices().addListener((Change<? extends Integer> c) -> {
    listViewRight.getSelectionModel().clearSelection();
    for (int selected : listViewLeft.getSelectionModel().getSelectedIndices()) {
        listViewRight.select(selected);
    }
});
listViewRight.getSelectionModel().getSelectedIndices().addListener((Change<? extends Integer> c) -> {
    listViewLeft.getSelectionModel().clearSelection();
    for (int selected : listViewRight.getSelectionModel().getSelectedIndices()) {
        listViewLeft.select(selected);
    }
});