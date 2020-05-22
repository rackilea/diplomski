FileChannel channel = new RandomAccessFile("C:\\foo", "rw").getChannel();

// Try acquiring the lock without blocking. This method returns
// null or throws an exception if the file is already locked.
FileLock lock = channel.tryLock();

// ...  

// release it
lock.release();