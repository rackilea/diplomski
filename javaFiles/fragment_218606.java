interface Path {}
class PathImpl implements Path {
  String path;
  PathImpl(String path) { this.path = path; }
}
class Paths {
  static Path get(String path) { return new PathImpl(path); }
}