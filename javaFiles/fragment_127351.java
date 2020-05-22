label.textProperty().bind(
    task.progressProperty()
    .multiply(-1)
    .add(1)
    .multiply(saveSpeedInt)
    .asString("Seconds remaining: %.0f"));