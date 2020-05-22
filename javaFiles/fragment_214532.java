class LongIntParallelHashMultimap {
    private static final int NULL = 0;
    private final FileChannel channel1, channel2;
    private final LongBuffer keys;
    private final IntBuffer values;
    private final int capacity;
    private int size;

    public LongIntParallelHashMultimap(int capacity, String basename) throws IOException {
        assert (capacity & (capacity - 1)) == 0 : "Capacity " + capacity + " must be a power of 2";
        this.capacity = capacity;
        channel1 = new RandomAccessFile(basename + ".keys", "rw").getChannel();
        keys = channel1.map(FileChannel.MapMode.READ_WRITE, 0, capacity * 8).order(ByteOrder.nativeOrder()).asLongBuffer();
        // load keys into memory
        for(int i=0;i<capacity;i+=512) keys.get(i);

        channel2 = new RandomAccessFile(basename + ".values", "rw").getChannel();
        values = channel2.map(FileChannel.MapMode.READ_WRITE, 0, capacity * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
        for(int i=0;i<capacity;i+=1024) values.get(i);
    }

    public void put(long key, int value) {
        long key1 = key + 1;
        int index = indexFor(key1);
        while (keys.get(index) != NULL) {
            index = successor(index);
        }
        values.put(index, value);
        keys.put(index, key1);
        ++size;
    }

    /**
     * Uses a pre-allocated array and return the count of matches.
     */
    public int get(long key, int[] hits) {
        long key1 = key + 1;
        int index = indexFor(key1);
        int hitIndex = 0;

        while (keys.get(index) != NULL) {
            if (keys.get(index) == key1) {
                hits[hitIndex] = values.get(index);
                ++hitIndex;
            }
            index = successor(index);
        }

        return hitIndex;
    }

    private int indexFor(long key) {
        return Math.abs((int) ((key * 5700357409661598721L) & (capacity - 1)));
    }

    private int successor(int index) {
        return (index + 1) & (capacity - 1);
    }

    public int size() {
        return size;
    }

    public void close() {
        try {
            channel1.close();
            channel2.close();
        } catch (IOException ignored) {
        }
        try {
            ((DirectBuffer) keys).cleaner().clean();
            ((DirectBuffer) values).cleaner().clean();
        } catch (Throwable notSupportedOnThisPlatform) {
        }
    }
}