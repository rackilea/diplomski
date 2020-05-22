BufferedReader fromClient;
    Properties serverProps = new Properties();


// ... code to construct fromClient from the socket ...

    serverProps.load (new PropReader (fromClient));

/////

    private static class PropReader extends Reader {

    BufferedReader src;
    boolean eof=false;

    private PropReader(BufferedReader fromClient) {
        super();
        src=fromClient;
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int inCount;

        if (!eof) {
            inCount = src.read(cbuf, off, len);

            if (inCount > 0) {
                // we read a buffer... look at the end for the EOF that the client used to mark the end of file
                if (cbuf[off+inCount-1] == '\u001A') {
                    --inCount; // don't send eof with the data
                    eof = true; // next time... we'll return -1
                }
            }
        } else {
            inCount = -1;
        }

        return inCount;
    }

    @Override
    public void close() throws IOException {
        src.close();
    }