public static void zip(final File destination, final List<File> toZip) throws IOException {
    try (final ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(destination))) {
        for (final File file : toZip) {
            final ZipEntry entry = new ZipEntry(file.getCanonicalPath());
            zip.putNextEntry(entry);
            zip.write(Files.readAllBytes(file.toPath()));
        }
    }
}