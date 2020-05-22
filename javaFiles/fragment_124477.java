public class FTPClientPolling {

    private static FTPClientPolling instance = new FTPClientPolling();

    private FTPClientPolling() {
        logger.info("Object created for Client Polling");
        initializeFTPClient();
    }

    public static FTPClientPolling getInstance() {
        return instance;
    }

    public static void initializeFTPClient() {
        // initialize the values from properties file
    }

    public void startPolling() {

        FTPClient ftpClient = null;
        try {
            //connecting to ftp server

            //iterating the files in it
            FTPFile[] filesList = ftpClient.listFiles();
            for (FTPFile tmpFile : filesList) {
                //..
                File tempFile = File.createTempFile(tmpFile.getName(), null);
                FileOutputStream fileOut = new FileOutputStream(tempFile);
                ftpClient.retrieveFile(tmpFile.getName(), fileOut);

                //adding the file to the Queue of the file processor
                FileProcessor.getInstance().getFilesToBeProcessedQueue().add(tempFile);
            }

            if (ftpClient.isConnected())
                ftpClient.disconnect();
        } catch (Exception e) {
            //logging
        } finally {
            //closing ftpclient
        }

    }
}