private BooleanBinding areTheyEmptyBinding(List<TextField> list){   
    BooleanBinding bind = new SimpleBooleanProperty(false).not();
    for (TextField text: list)
        bind = bind.and(text.textProperty().isEmpty());
    return bind;
}