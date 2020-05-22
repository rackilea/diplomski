RandomAccessFile raFile = new RandomAccessFile(filename, 'rw');
FileChannel fc = raFile.getChannel();
fc.lock();
fc.truncate(0);
fc.write(someBuffer);
raFile.close(); // Will release the lock.