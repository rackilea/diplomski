public static void setUniform(final UniformLocation uniformLocation, final int value) {
    setUniformImpl(uniformLocation, u -> GL20.glUniform1i(u, value));
}

private static void setUniformImpl(final UniformLocation uniformLocation, final Consumer<Location> consumer) {
    ...
    consumer.accept(uniformLocation.getLocation());
    ...
}