Path directoryTarget = Paths.get("c:/temp");
Path directoryLink = Paths.get("c:/links/linkTemp");

Files.exists(directoryTarget);

try {
  Files.createSymbolicLink(directoryLink, directoryTarget);
} catch (IOException e) {
  e.printStackTrace();
}