public static void unzip(final String file) throws IOException {
    final File source = new File(file);
    unzip(
            new ZipFile(source),
            new File(source.getParent(), source.getName().substring(0, source.getName().lastIndexOf('.')))
    );
}

public static void unzip(final String source, final String destination) throws IOException {
    unzip(new File(source), new File(destination));
}

public static void unzip(final File source, final File destination) throws IOException {
    unzip(new ZipFile(source), destination);
}