private void getBytesFromFile(File file) throws IOException {
    FileInputStream is = new FileInputStream(file); //videorecorder stores video to file

    java.nio.channels.FileChannel fc = is.getChannel();
    java.nio.ByteBuffer bb = java.nio.ByteBuffer.allocate(10000);

    int chunkCount = 0;

    byte[] bytes;

    while(fc.read(bb) >= 0){
        bb.flip();
        //save the part of the file into a chunk
        bytes = bb.array();
        storeByteArrayToFile(bytes, mRecordingFile + "." + chunkCount);//mRecordingFile is the (String)path to file
        chunkCount++;
        bb.clear();
    }
}

private void storeByteArrayToFile(byte[] bytesToSave, String path) throws IOException {
    FileOutputStream fOut = new FileOutputStream(path);
    try {
        fOut.write(bytesToSave);
    }
    catch (Exception ex) {
        Log.e("ERROR", ex.getMessage());
    }
    finally {
        fOut.close();
    }
}