final RandomAccessFile file = new RandomAccessFile(filename, "rw");
final FileChannel channel = file.getChannel();
final byte[] data = new byte[2048];          // lets say it's got the data you want
final ByteBuffer buff = ByteBuffer.wrap(data);

channel.position(0);                         // (we were already here, but as an example)
channel.write(buff);                         // writes the entire 2028 bytes from buff
channel.force(false);                        // (superfluous if you close() afterwards)
channel.close();                             // close the file descriptor