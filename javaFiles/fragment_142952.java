ImageView iv = new ImageView();

ComboBox<Path> comboBox = new ComboBox<>();
comboBox.setConverter(new StringConverter<Path>() {

    @Override
    public String toString(Path object) {
        return object.getFileName().toString();
    }

    @Override
    public Path fromString(String string) {
        throw new UnsupportedOperationException();
    }

});

iv.imageProperty().bind(Bindings.createObjectBinding(() -> {
    Path path = comboBox.getValue();

    // use url for the given path
    return path == null ? null : new Image(path.toUri().toURL().toExternalForm());
}, comboBox.valueProperty()));