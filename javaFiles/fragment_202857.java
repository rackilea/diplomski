private static void relocateFile(Path original, Path newLoc) throws IOException {
  if(Files.isDirectory(newLoc)) {
    newLoc = newLoc.resolve(original.getFileName());
  }
  Files.move(original, newLoc);
}