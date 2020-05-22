public class BlockStore {

    private ConcurrentHashMap<Integer, BlockingQueue<Long>> blockToOffset = new ConcurrentHashMap<>();
    private RandomAccessFile randomAccessFile;

    public BlockStore(RandomAccessFile randomAccessFile, long fileLength) throws IOException {
        this.randomAccessFile = randomAccessFile;
        randomAccessFile.setLength(fileLength);
    }

    private synchronized BlockingQueue<Long> ensureQueueExists(int key) {
        if (blockToOffset.containsKey(key)) {
            return blockToOffset.get(key);
        } else {
            BlockingQueue<Long> queue = new ArrayBlockingQueue<>(1);
            blockToOffset.put(key, queue);
            return queue;
        }
    }

    public void getBlock(int blockNumber, byte[] buffer) {
        BlockingQueue<Long> queue = ensureQueueExists(blockNumber);
        try {
            long offset = queue.poll(60L, TimeUnit.SECONDS);
            queue.add(offset); // Put offset back into queue. Since get will only be called by one thread, this does not result in a race condition
            randomAccessFile.seek(offset);
            randomAccessFile.readFully(buffer);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void writeBlock(int blockNumber, byte[] buffer) throws IOException {
        BlockingQueue<Long> queue = ensureQueueExists(blockNumber);
        long offset = blockNumber * NodeUtil.FILE_BUFFER_SIZE;
        randomAccessFile.seek(offset);
        randomAccessFile.write(buffer);
        queue.add(offset);
        blockToOffset.put(blockNumber, queue);
    }

    public boolean allFilesReceived() throws IOException {
        double expectedNumberOfBlocks = Math.ceil(((double) randomAccessFile.length()/NodeUtil.FILE_BUFFER_SIZE));
        return expectedNumberOfBlocks == blockToOffset.size();
    }
}