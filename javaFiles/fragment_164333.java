ftpClient.setSecurity(FTPClient.SECURITY_FTPES);
// get the FTP connection
    String[] fileNames = ftpClient.listNames();

// Exisitng implementation
FTPFile[] ftpFiles = ftpClient.list("*.zip");
// after that there is an implementation for getting the latest files using the Comparator<FTPFile>