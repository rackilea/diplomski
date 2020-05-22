speedLabel.widthProperty().addListener((obs, oldVal, newVal) -> {
    backgroundLabel.setWidth(newVal.doubleValue());
});

speedLabel.heightProperty().addListener((obs, oldVal, newVal) -> {
    backgroundLabel.setHeight(newVal.doubleValue());
});