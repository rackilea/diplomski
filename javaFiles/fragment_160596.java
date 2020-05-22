Path dir = ...
try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
  int count = length(stream.iterator());
  for (Path entry: stream) {
    ...
  }
}