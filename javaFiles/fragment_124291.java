public class WireLogSSLSocketFactory extends SSLSocketFactory {

    private SSLSocketFactory delegate;

    public WireLogSSLSocketFactory(SSLSocketFactory sf0) {
        this.delegate = sf0;
    }

    public Socket createSocket(Socket s, String host, int port,
            boolean autoClose) throws IOException {
        return new WireLogSocket((SSLSocket) delegate.createSocket(s, host, port, autoClose));
    }

    /*
    ...
    */

    private static class WireLogSocket extends SSLSocket {

        private SSLSocket delegate;

        public WireLogSocket(SSLSocket s) {
            this.delegate = s;
        }

        public OutputStream getOutputStream() throws IOException {
            return new LoggingOutputStream(delegate.getOutputStream());
        }

        /*
        ...
        */

        private static class LoggingOutputStream extends FilterOutputStream {
            private static final Logger logger = Logger.getLogger(WireLogSocket.LoggingOutputStream.class);
            //I'm using a fixed charset because my app always uses the same. 
            private static final String CHARSET = "ISO-8859-1";
            private StringBuffer sb = new StringBuffer();

            public LoggingOutputStream(OutputStream out) {
                super(out);
            }

            public void write(byte[] b, int off, int len)
                    throws IOException {
                sb.append(new String(b, off, len, CHARSET));
                logger.info("\n" + sb.toString());
                out.write(b, off, len);
            }

            public void write(int b) throws IOException {
                sb.append(b);
                logger.info("\n" + sb.toString());
                out.write(b);
            }

            public void close() throws IOException {
                logger.info("\n" + sb.toString());
                super.close();
            }
        }
    }
}