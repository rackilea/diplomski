public ExclusiveApplicationLock
     throws Exception {

   private final File file;
   private final FileChannel channel;
   private final FileLock lock;

   private ExclusiveApplicationLock()  {

       String homeDir = System.getProperty("user.home");

       file = new File(homeDir + "/.myapp", app.lock");
       if (file.exists()) {
          file.delete();
       }

       channel = new RandomAccessFile(file, "rw").getChannel();
       lock = channel.tryLock();
       if (lock == null)  {
          channel.close();
          throw new RuntimeException("Application already running.");
       }

       Runtime.getRuntime().addShutdownHook(new Thread(() -> releaseLock());            
  }

  private void releaseLock() {
    try {
      if (lock != null) {
        lock.release();
        channel.close();
        file.delete();
      }
    }
    catch (Exception ex) {
       throw new RuntimeException("Unable to release application process lock", ex);
    }
  }
}