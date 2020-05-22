public static void unzip(final ZipFile zipfile, final File directory)
    throws IOException {

    final Enumeration<? extends ZipEntry> entries = zipfile.entries();
    while (entries.hasMoreElements()) {
        final ZipEntry entry = entries.nextElement();
        final File file = file(directory, entry);
        if (entry.isDirectory()) {
            continue;
        }
        final InputStream input = zipfile.getInputStream(entry);
        try {
            // copy bytes from input to file
        } finally {
            input.close();
        }
    }
}