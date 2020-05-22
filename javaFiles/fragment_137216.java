btnPersonalized.selectedProperty().addListener((o, oldValue, newValue) -> {
    if (newValue) {
        borderOnce.setCenter(nodeToDisplay);
    } else {
        borderOnce.setCenter(null);
    }
});