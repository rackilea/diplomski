try (
    InputStream in = ...
) {
    // read from input stream.
}

// that's it. You do not have to close in. It will be closed automatically since InputStream implements Closable.