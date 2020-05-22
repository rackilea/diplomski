private static void getBuildInformation(Path path) {
    Supplier<Stream<String>> streamSupplier = () -> lines(path);
    //do your stuff
}
private static Stream<String> lines(Path path) {
    try { 
        return Files.lines(path); 
    }
    catch (IOException e) { 
        throw new UncheckedIOException(e); 
    }
}