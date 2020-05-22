public static void main(String... args) throws Exception {
    final String[] pkgs = {"com.example.jersey"};
    final boolean recursive = true;

    final AnnotationAcceptingListener asl = new AnnotationAcceptingListener(Path.class);
    final PackageNamesScanner scanner = new PackageNamesScanner(pkgs, recursive);
    while (scanner.hasNext()) {
        final String next = scanner.next();
        if (asl.accept(next)) {
            try (final InputStream in = scanner.open()) {
                asl.process(next, in);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    asl.getAnnotatedClasses().forEach(System.out::println);
}