public class AutoDetectInputStream extends InputStream  {
    private InputStream is;
    private byte[] sampleData = new byte[4096];
    private int sampleLen;
    private int sampleIndex = 0;

    public AutoDetectStream(InputStream is) throws IOException {
        this.is = is;
        // pre-read the data
        sampleLen = is.read(sampleData);
    }

    public Charset getCharset() {
        // detect the charset
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData(sampleData, 0, sampleLen);
        detector.dataEnd();
        return detector.getDetectedCharset();
    }

    @Override
    public int read() throws IOException {
        // simulate the stream for the reader
        if(sampleIndex < sampleLen) {
            return sampleData[sampleIndex++];
        }
        return is.read();
    }
}