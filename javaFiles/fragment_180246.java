final Path target = Paths.get("tééé ê.mp3");

try (
    final OutputStream out = Files.newOutputStream(target, StandardOpenOption.CREATE_NEW);
) {
    // write
}