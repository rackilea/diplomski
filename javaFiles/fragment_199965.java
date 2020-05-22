PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:/Users/username/workspace/*");
Files.walk(Paths.get(".")).forEach((path) -> {
    path = path.toAbsolutePath().normalize();
    System.out.print("Path: " + path + " ");
    if (pathMatcher.matches(path)) {
        System.out.print("matched");
    }
    System.out.println();
});