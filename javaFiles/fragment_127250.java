nodeA.heightProperty().asObject().addListener((obs, oldValue, newValue) -> {
    // obs is now an ObservableValue<Double>, if you need it
    // oldValue is a Double, which can be treated as a double via unboxing
    // similarly newValue is a Double

    // do stuff..
});