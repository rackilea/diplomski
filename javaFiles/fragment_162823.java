final long size = 10000000000L;
final File file = new File("d://file.mp4");
volatile boolean cancelled = false;

Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        long bytesRemaining = size;
        long currentSize = 0;
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        try {
            while ( bytesRemaining > 0 && !cancelled ) {
                // !!!THIS IS NOT EXACTLY CORRECT SINCE
                // YOU WILL NEED TO HANDLE EDGE CONDITIONS
                // AS YOU GET TO THE END OF THE FILE.
                // IT IS MEANT AS AN ILLUSTRATION ONLY!!!
                currentSize += CHUNK_SIZE; // you decide how big chunk size is
                raf.setLength(currentSize);
                bytesRemaining -= CHUNK_SIZE 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});
t.start();

// some other thread could cancel the writing by setting the cancelled flag