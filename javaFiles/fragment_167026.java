private static final int CHUNK_SIZE=512*8*1024;  // 4Mb chunk

private RandomAccessFile raf; 
private long currentChunk=-1;
private byte[] chunk=new byte[CHUNK_SIZE];

public void flush() throws Exception{
    raf = new RandomAccessFile(new File("./db.bin"),"rw");
    List<Long> c=something();

    c.stream().sorted().forEach(this::process);

    saveChunk();
}

public void process(long l) {
    try {
        if (l/8/CHUNCK_SIZE!=currentChunk) {
            saveChunk();
            loadNextChunk();
        }

        long posInMem=(l/8) - (CHUNK_SIZE*currentChunk);
        byte b=chunk[(int)posInMem];
        chunk[(int)posInMem]=editByte(b,(int)l % 8);
    }catch(Exception e) {
        e.printStackTrace();
    }
}

private void loadNextChunk()throws Exception {
    currentChunk++;
    raf.seek(currentChunk*CHUNK_SIZE);
    raf.readFully(chunk, 0, CHUNK_SIZE);
}

private void saveChunk() throws Exception {
    if (currentChunk<0)return;
    raf.seek(currentChunk*CHUNK_SIZE);
    raf.write(chunk, 0, CHUNK_SIZE);
}