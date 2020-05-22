class RootlessJsonProvider<T> extends JsonProvider<T> {
    @Override
    T readFrom(Class<T> ...) {
    }
}

JsonProvider<SomeClassOfOurs> rootlessProvider = new RootlessJsonProvider<>(...);