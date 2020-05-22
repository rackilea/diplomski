//Read the TLS record
    ByteBuffer recordData = ByteBuffer.allocateDirect(recordLength);
    int ttl = read(recordData);
    if (ttl<recordLength){
        while (ttl<recordLength){
            recordData.position(ttl);
            ByteBuffer tmp = ByteBuffer.allocateDirect(recordLength-ttl);
            ttl += read(tmp);
            recordData.put(tmp);
        }
        recordData.rewind();
    }