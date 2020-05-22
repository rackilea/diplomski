protected static File file(final File root, final ZipEntry entry)
    throws IOException {

    final File file = new File(root, entry.getName());

    File parent = file;
    if (!entry.isDirectory()) {
        final String name = entry.getName();
        final int index = name.lastIndexOf('/');
        if (index != -1) {
            parent = new File(root, name.substring(0, index));
        }
    }
    if (parent != null && !parent.isDirectory() && !parent.mkdirs()) {
        throw new IOException(
            "failed to create a directory: " + parent.getPath());
    }

    return file;
}