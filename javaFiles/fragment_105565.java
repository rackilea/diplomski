public static void unzip(final ZipFile source, final File destination) throws IOException {
    for (final ZipEntry entry : Collections.list(source.entries())) {
        unzip(source, entry, destination);
    }
}

private static void unzip(final ZipFile source, final ZipEntry entry, final File destination) throws IOException {
    if (!entry.isDirectory()) {
        final File resource = new File(destination, entry.getName());
        if (!resource.getCanonicalPath().startsWith(destination.getCanonicalPath() + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + entry);
        }

        final File folder = resource.getParentFile();
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new IOException();
            }
        }

        try (final BufferedInputStream input = new BufferedInputStream(source.getInputStream(entry));
             final BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(resource))) {
            output.write(input.readAllBytes());
            output.flush();
        }
    }
}