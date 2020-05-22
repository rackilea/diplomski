public void close() throws IOException {
    SecurityManager security = System.getSecurityManager();
    if (security != null) {
        security.checkPermission(new RuntimePermission("closeClassLoader"));
    }
    List<IOException> errors = ucp.closeLoaders();
    // now close any remaining streams.
    synchronized (closeables) {
        Set<Closeable> keys = closeables.keySet();
        for (Closeable c : keys) {
            try {
                c.close();
            } catch (IOException ioex) {
                errors.add(ioex);
            }
        }
        closeables.clear();
    }
    if (errors.isEmpty()) {
        return;
    }
    IOException firstex = errors.remove(0);
    // Suppress any remaining exceptions
    for (IOException error: errors) {
        **firstex.addSuppressed(error);**
    }
    throw firstex;
}