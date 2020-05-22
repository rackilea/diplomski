FileInputStream in = new FileInputStream(file);
try {
    java.nio.channels.FileLock lck = in.getChannel().lock();
    try {
        Reader reader = new InputStreamReader(in, charset);
        ...
    } finally {
        lck.release();
    }
} finally {
    in.close();
}