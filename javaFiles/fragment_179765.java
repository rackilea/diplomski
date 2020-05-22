BooleanBinding bb = Bindings.createBooleanBinding(() -> {
    LocalDate from = dpFromDate.getValue();
    LocalDate to = dpToDate.getValue();

    // disable, if one selection is missing or from is not smaller than to
    return (from == null || to == null || (from.compareTo(to) >= 0));
}, dpFromDate.valueProperty(), dpToDate.valueProperty());

button.disableProperty().bind(bb);