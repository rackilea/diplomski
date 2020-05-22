public class MyWorker extends SwingWorker<Object, Object> {

    private URL host;
    private File outputFile;

    public MyWorker(URL host, File f) {
        this.host = host;
        outputFile = f;
    }

    @Override
    protected Object doInBackground() throws Exception {

        // You're ignoring the host you past in to the constructor
        String hostName = "localhost";
        String username = "un";
        String password = "pass";
        String location = f.toString();

        //FTPClient ftp = null;

        ftp.connect(hostName, 2121);
        ftp.login(username, password);

        ftp.setFileType(FTP.BINARY_FILE_TYPE);

        ftp.setKeepAlive(true);
        ftp.setControlKeepAliveTimeout(3000);
        ftp.setDataTimeout(3000); // 100 minutes
        ftp.setConnectTimeout(3000); // 100 minutes

        ftp.changeWorkingDirectory("/SSL");

        int reply = ftp.getReplyCode();
        System.out.println("Received Reply from FTP Connection:" + reply);

        if (FTPReply.isPositiveCompletion(reply)) {
            System.out.println("Connected Success");
        }
        System.out.println(f.getName().toString());

        File f1 = new File(location);
        in = new FileInputStream(f1);

        FileInputStream input = new FileInputStream(f1);
        // ftp.storeFile(f.getName().toString(),in);

        //ProgressMonitorInputStream is= new ProgressMonitorInputStream(getParent(), "st", in);
        OutputStream ftpOut = ftp.storeFileStream(f.getName().toString());


        System.out.println(ftpOut.toString());
        //newname hereSystem.out.println(ftp.remoteRetrieve(f.toString()));
        OutputStream output = new BufferedOutputStream(ftpOut);
        CopyStreamListener listener = new CopyStreamListener() {
            public void bytesTransferred(final long totalBytesTransferred, final int bytesTransferred, final long streamSize) {

                setProgress((int) Math.round(((double) totalBytesTransferred / (double) streamSize) * 100d));

            }

            @Override
            public void bytesTransferred(CopyStreamEvent arg0) {
                // TODO Auto-generated method stub
            }
        };

        Util.copyStream(input, output, ftp.getBufferSize(), f.length(), listener);

        return null;

    }
}