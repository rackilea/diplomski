InputStream in = null;
try {
    in = ...
    // use the stream here.
} finally {
    if (in != null) {
        in.close();
    }
}