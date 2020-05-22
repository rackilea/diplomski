class RootlessJsonProvider extends JsonProvider<SomeClassOfOurs> {
    @Override
    SomeClassOfOurs readFrom(Class<SomeClassOfOurs> ...) {
    }
}

JsonProvider<SomeClassOfOurs> rootlessProvider = new RootlessJsonProvider(...);