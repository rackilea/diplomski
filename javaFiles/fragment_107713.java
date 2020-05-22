private static void foo(String path, String... files) throws Exception {
    try (CompositeAutoclosable<Stream<String>> streams 
            = new CompositeAutoclosable<Stream<String>>()) {
        for (int i = 0; i < files.length; i++) {
            final String file = files[i];
            streams.addComponent(Files.lines(Paths.get(path, file))
                .onClose(() -> System.out.println("Closed " + file)));
        }
        streams.getComponents().stream()
            .parallel()
            .flatMap(x -> x)
            .distinct()
            .sorted()
            .limit(10)
            .forEach(System.out::println);
    }
}