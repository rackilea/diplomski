private void loadList(String[] ss) {
    final ObservableList<String> list = FXCollections.observableArrayList(ss);
    Platform.runLater(() -> {
        lv.setItems(list);
    });
}