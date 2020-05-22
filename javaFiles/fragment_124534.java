public static void main(String[] args) {
    String server = "ftp://ftp.dlptest.com/";
    int port = 21;
    String user = "dlpuser@dlptest.com";
    String pass = "fLDScD4Ynth0p4OJ6bW6qCxjh";

    FTPClient ftpClient = new FTPClient();
    try {

        ftpClient.connect(server, port);
        ftpClient.login(user, pass);
        ftpClient.enterLocalPassiveMode();

        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        File firstLocalFile = new File("C:/Users/Administrator/Desktop/Book1.xlsx");

        String firstRemoteFile = "Book1.xlsx";
        InputStream inputStream = new FileInputStream(firstLocalFile);

        System.out.println("Start uploading first file");
        boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
        inputStream.close();
        if (done) {
            System.out.println("The first file is uploaded successfully.");
        }
    } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}