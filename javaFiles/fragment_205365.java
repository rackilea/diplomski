try {
            InputStream stO =
                new BufferedInputStream(
                    ftp.retrieveFileStream("foo.bar"),
                    ftp.getBufferSize());

            OutputStream stD =
                new FileOutputStream("bar.foo");

            org.apache.commons.net.io.Util.copyStream(
                    stO,
                    stD,
                    ftp.getBufferSize(),
/* I'm using the UNKNOWN_STREAM_SIZE constant here, but you can use the size of file too */
                    org.apache.commons.net.io.CopyStreamEvent.UNKNOWN_STREAM_SIZE,
                    new org.apache.commons.net.io.CopyStreamAdapter() {
                        public void bytesTransferred(long totalBytesTransferred,
                                int bytesTransferred,
                                long streamSize) {
                                // Your progress Control code here
                        }
            });
            ftp.completePendingCommand();
        } catch (Exception e) { ... }