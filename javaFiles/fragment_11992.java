previous.disableProperty().bind(
    list.getSelectionModel().selectedIndexProperty().isEqualTo(0));

next.disableProperty().bind(
    list.getSelectionModel().selectedIndexProperty().isEqualTo(
        Bindings.size(list.getItems()).subtract(1)));