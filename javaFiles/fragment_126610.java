Stream<Object> getStream() {
    return Stream.of(new Object())
        .filter(e -> {
            if (true) throw new IllegalStateException();
            return true;
        })
        .onClose(() -> System.out.println("OnClose"));
}