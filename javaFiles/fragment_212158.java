public static void splitAndGenerateParityFile(File file, int shardCount, String fileID) throws IOException {
    int BUFFER_SIZE = 4 * 1024 * 1024;
    RandomAccessFile rin = new RandomAccessFile(file, "r");
    FileChannel fcin = rin.getChannel();

    //Create parity files
    File parity = new File(fileID + "_parity");
    if (parity.exists()) throw new FileAlreadyExistsException("Could not create parity file! File already exists!");
    RandomAccessFile parityRAF = new RandomAccessFile(parity, "rw");
    FileChannel parityOut = parityRAF.getChannel();

    //Create shard files
    ArrayList<File> shards = new ArrayList<>(shardCount);
    for (int i = 0; i < shardCount; i++) {
        File f = new File(fileID + "_part_" + i);
        if (f.exists()) throw new FileAlreadyExistsException("Could not create shard file! File already exists!");
        shards.add(f);
    }

    long bytesPerFile = (long) Math.ceil(rin.length() / shardCount);

    ArrayList<ByteBuffer> shardBuffers = new ArrayList<>(shardCount);

    //Make buffers for each section of the file we will be reading from
    for (int i = 0; i < shardCount; i++) {
        ByteBuffer bb = ByteBuffer.allocate(BUFFER_SIZE);
           shardBuffers.add(bb);
    }

    ByteBuffer parityBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    //Generate parity
    boolean isParityBufferEmpty = true;
    for (long i = 0; i < bytesPerFile; i++) {
        isParityBufferEmpty = false;
        int pos = (int) (i % BUFFER_SIZE);
        byte p = 0;

        if (pos == 0) {
            //Read chunk of file into each buffer
            for (int j = 0; j < shardCount; j++) {
                ByteBuffer bb = shardBuffers.get(j);
                bb.clear();
                fcin.position(bytesPerFile * j + i);
                fcin.read(bb);
                bb.flip();
            }

            //Dump parity buffer
            if (i > 0) {
                parityBuffer.flip();
                while (parityBuffer.hasRemaining()) {
                    parityOut.write(parityBuffer);
                }
                parityBuffer.clear();
                isParityBufferEmpty = true;
            }
        }

        //Get parity
        for (ByteBuffer bb : shardBuffers) {
            if (!bb.hasRemaining()) break;
            p ^= bb.get();
        }

        //Put parity in buffer
        parityBuffer.put(p);
    }

    if (!isParityBufferEmpty) {
        parityBuffer.flip();
        parityOut.write(parityBuffer);
        parityBuffer.clear();
    }

    fcin.close();
    rin.close();
    parityOut.close();
    parityRAF.close();
}