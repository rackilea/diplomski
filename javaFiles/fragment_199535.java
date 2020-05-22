InputStream stSource = new FileInputStream(locFile);
OutputStream stDest = new BufferedOutputStream(ftp.storeFileStream(remFile), ftp.getBufferSize());

Util.copyStream(stSource, stDest, ftp.getBufferSize(),CopyStreamEvent.UNKNOWN_STREAM_SIZE, new CopyStreamAdapter() {
    public void bytesTransferred(long totalBytesTransferred,int bytesTransferred, long streamSize) {
        long megsTotal = 0;
        long megs = totalBytesTransferred / 1048576;

        for (long l = megsTotal; l < megs; l++) {
            System.err.print("|");
        }

        megsTotal = megs;
    }
});