short[] recordBuf = new short[bufferSize];
byte[] myBuf = new byte[bufferSize];

...

    int l = audioRecord.read(recordBuf, 0, recordBuf.length);
    if (l > 0) {
        for (int i = 0; i < l; i++) {
           myBuf[i] = (byte)(recordBuffer[I] >> 8);
        }
        // process data
    }