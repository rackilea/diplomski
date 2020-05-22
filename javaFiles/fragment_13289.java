box.focusedProperty().addListener((observable, oldValue, newValue) -> {
        selectTextIfFocused(box);
    });
    box.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        selectTextIfFocused(box);
    });