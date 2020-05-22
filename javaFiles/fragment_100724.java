Optional<String> result = Optional.empty();
    for (Supplier<String> stringSupplier : Arrays.<Supplier<String>>asList(this::method1, this::method2, this::method3)) {
        String s = stringSupplier.get();
        if (s != null) {
            result = Optional.of(s);
            break;
        }
    }