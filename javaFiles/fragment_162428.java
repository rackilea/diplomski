private static List<String> subDirectories(File pathname) {
    return Arrays.stream(pathname.listFiles())
                   .filter(File::isDirectory)
                   .map(File::getName)
                   .collect(Collectors.toList());
}