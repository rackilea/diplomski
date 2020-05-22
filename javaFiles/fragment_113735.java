Path prefix    = Paths.get(path);
Path directory = prefix.getParent();

try (Stream<Path> stream = Files.list(directory)) {
    stream.filter(p -> p.getFileName().startsWith(prefix.getFileName() + "."))
          .forEach(p -> System.out.printf("Found %s%n", p));
}