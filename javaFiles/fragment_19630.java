DataOutputStream dataOutStream = new DataOutputStream(
            new FileOutputStream("test1"));
    int numberOfChunks = 2;
    dataOutStream.writeInt(numberOfChunks);// Write number of chunks first
    byte[] firstChunk = "HI".getBytes();
    dataOutStream.writeInt(firstChunk.length);//Write length of array a small custom protocol
    dataOutStream.write(firstChunk);//Write byte array

    byte[] secondChunk = "BYE".getBytes();
    dataOutStream.writeInt(secondChunk.length);//Write length of array
    dataOutStream.write(secondChunk);//Write byte array

    RandomAccessFile randomAccessFile = new RandomAccessFile("test1", "r");
    int chunksRead = randomAccessFile.readInt();
    for (int i = 0; i < chunksRead; i++) {
        int size = randomAccessFile.readInt();
        if (i == 1)// means we only want to read last chunk
        {
            byte[] bytes = new byte[size];
            randomAccessFile.read(bytes, 0, bytes.length);
            System.out.println(new String(bytes));
        }
        randomAccessFile.seek(4+(i+1)*size+4*(i+1));//From start so 4 int + i* size+ 4* i ie. size of i
    }