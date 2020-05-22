File file = new File(path);
File parent = file.getParentFile();
// TODO: Handle parent existing, but not being a directory,
// or file existing, but being a directory...
if (!parent.exists()) {
    parent.mkdirs();
}

try (OutputStream output = new FileOutputStream(file)) {
    // ...
}