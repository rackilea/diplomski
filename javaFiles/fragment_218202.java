Set<String> names = new LinkedHashSet<>();
// ...
while (scan.hasNextLine() && names.size() < 100) {
  if (names.add(scan.nextLine()) {
    // Only runs if it wasn't there before.
  }
}