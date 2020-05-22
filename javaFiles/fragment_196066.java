try (
    FileInputStream stream = new FileInputStream(source);
    Input input = new Input(stream)
) {
    ...
}