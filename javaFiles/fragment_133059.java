Properties properties=new Properties();

try(final FileChannel channel = FileChannel.open(filePath, StandardOpenOption.READ);
    final FileLock lock = channel.lock(0L, Long.MAX_VALUE, true)) {

    properties.load(Channels.newInputStream(channel));
}