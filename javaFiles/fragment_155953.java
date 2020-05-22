MethodHandles.Lookup lookup = MethodHandles.lookup();
MethodType methodType = MethodType.methodType(void.class, String.class);
MethodHandle handle = lookup.findVirtual(PrintStream.class, "println", methodType);

consumers.put("println", s -> {
    try {
        handle.invokeExact(System.out, s);
    } catch (Throwable e) {
        throw new RuntimeException(e);
    }
});

consumers.get("println").accept("foo");