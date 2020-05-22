// Gets a readable and writable channel to your file.
FileChannel channel = new RandomAccessFile(yourFile, "rw").getChannel();

// Allows you to read from the file.
InputStream in = Channels.getInputStream(channel);

// Allows you to write to the file.
OutputStream out = Channels.getOutputStream(channel);

// Lock the file here as you see fit to prevent concurrency issues.
// As a concrete example, you could attempt to lock the file using "channel.tryLock()"
...