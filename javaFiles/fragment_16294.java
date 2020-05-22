private void checkReleasedLock() throws IOException {
        File file = new File("config\\file.lock");
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        FileLock lock;

        try {
            lock = channel.tryLock();
            if (lock != null) {
                System.exit(0);
            }
        } finally {
            channel.close();
        }
    }