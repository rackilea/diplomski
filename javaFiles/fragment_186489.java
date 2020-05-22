if (handle.type().returnType() != Void.TYPE) {
    handle = handle.asType(handle.type().changeReturnType(Object.class)); // <---

    MethodHandle returnFilter = lookup.findVirtual(Util.class, "filter",
            MethodType.methodType(Object.class, Object.class));
    returnFilter = returnFilter.bindTo(new Util());
    handle = MethodHandles.filterReturnValue(handle, returnFilter);
}