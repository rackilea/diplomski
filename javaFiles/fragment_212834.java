FileLock lock = null;
FileChannel channel = null;
try {
  // Get a file channel for the file
  File file = new File("journal");
  channel = new RandomAccessFile(file,
      "rw").getChannel();

  // Try acquiring the lock without blocking.
  try {
    lock = channel.tryLock();
    if (lock != null) {
      // GOT THE LOCK.... DO WORK...
      return true; // write success.
    }
  } catch (OverlappingFileLockException e) {
    // File is already locked in this thread or virtual
    // machine
  } finally {
    if (lock != null) {
      lock.release(); // Release the lock
    }
    if (channel != null) {
      channel.close(); // Close the file.
    }
  }
  return false; // Write must be retried?