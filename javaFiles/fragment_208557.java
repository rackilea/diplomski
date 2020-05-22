try (Stream<Path> stream = Files.walk(Paths.get("/home/stanislav/test"))) {
    stream
        .sorted(Comparator.comparing(p -> p.toFile().length(), Comparator.reverseOrder()))
        .limit(5)
        .forEach(System.out::println);
}