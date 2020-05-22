RandomAccessFile file = new RandomAccessFile(/* some file */);
MappedByteBuffer buffer = file.getChannel().map(MapMode.READ_WRITE, 0, file.length());

// Some stuff happens...

// adjust the size
file.setLength(newLength);

// recreate the memory mapped buffer
buffer = file.getChannel().map(MapMode.READ_WRITE, 0, file.length());