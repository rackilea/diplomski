ObservableSet<String> set = FXCollections.observableSet();
ListView<String> listView = new ListView<>();
set.addListener((Change<? extends String> c) -> {
    if (c.wasAdded()) {
        listView.getItems().add(c.getElementAdded());
    }
    if (c.wasRemoved()) {
        listView.getItems().remove(c.getElementRemoved());
    }
});