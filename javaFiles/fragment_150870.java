try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
    while (raf.getChannel().tryLock() == null) {
        Thread.sleep(10);
    }
    // lock acquired
}