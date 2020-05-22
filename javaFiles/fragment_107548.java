FileInputStream in = new FileInputStream(file);
try {
    java.nio.channels.FileLock lock = in.getChannel().lock();
    try {
        Reader reader = new InputStreamReader(in, charset);
        ...
    } finally {
        lock.release();
    }
} finally {
    in.close();
}