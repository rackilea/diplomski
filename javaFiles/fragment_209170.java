try(FileChannel fch=FileChannel.open(fileToWrite.toPath(),
                                     StandardOpenOption.CREATE, StandardOpenOption.WRITE)){
  try(FileLock lock=fch.tryLock()) {
    if(lock!=null) {
      // you can directly write into the channel
      // but in case you really need an OutputStream:
      OutputStream fos=Channels.newOutputStream(fch);
      fos.write(testData.getBytes());
      // you may explicitly truncate the file to the actually written content:
      fch.truncate(fch.position());
      System.out.println("waiting while holding lock...");
      LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(5));
    }
    else System.out.println("couldn't acquire lock");
  }
}