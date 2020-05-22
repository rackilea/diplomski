public <T> boolean compare(Wrapper wrapper, Class<T> cls) {
    return cls.isInstance(wrapper.obj);
}

// and then, at the call site:
if (compare(wrapper, Foo.class)) {
    ...
}