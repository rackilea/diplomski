private void move(String suffix, Path source, Path destination) throws IOException {
    Files.createDirectories(destination);
    Files.walk(source)
         .filter(p -> p.toString().endsWith(suffix))
         .forEach(p -> {
             Path dest = destination.resolve(source.relativize(p));
             try {
                 Files.createDirectories(dest.getParent());
                 Files.move(p, dest);
             } catch (IOException e) {
                 throw new UncheckedIOException(e);
             }
         });
}