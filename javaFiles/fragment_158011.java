private int readFromStream(byte[] buffer, int index, int bufferSize_) {
    int bytes = 0;
    try {
        bytes = oggBitStream_.read(buffer, index, bufferSize_);
    }
    catch (Exception e) {
        if (TDebug.TraceAudioConverter)
            TDebug.out("Cannot Read Selected Song");
        bytes = -1;
    }
    if (bytes >= 0) {
        currentBytes += bytes;
    }
    return bytes;
}