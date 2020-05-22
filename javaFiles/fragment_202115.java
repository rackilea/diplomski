private final Class<T> clazz;

public Cache(Class<T> clazz) {
    this.clazz = clazz;
}

public void initialize(Context context) {
    ...
                        new JsonSerializer<>(clazz), context)