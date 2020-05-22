private double ratio = 1;

// ...

lock.selectedProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue) {
        hSelector.commitValue();
        wSelector.commitValue();
        ratio = (double) hSelector.getValue() / wSelector.getValue();
    }
});

hSelector.getValueFactory().valueProperty().addListener((ob, ov, nv) -> {
    if (lock.isSelected()) {
        wSelector.getValueFactory().setValue((int) (nv / ratio));
    }
});
wSelector.getValueFactory().valueProperty().addListener((ob, ov, nv) -> {
    if (lock.isSelected()) {
        hSelector.getValueFactory().setValue((int) (nv * ratio));
    }
});