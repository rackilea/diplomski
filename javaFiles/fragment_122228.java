try {
    String filePattern = "prefix";
    FTPClient objFTPClient = new FTPClient();
    //objFTPClient - set username, password, host, etc...
    FTPFileFilter ftpFileFilter = new FTPFileFilter() {
        @Override
        public boolean accept(FTPFile ftpFile) {
            return ftpFile.getName().toLowerCase().startsWith(filePattern.toLowerCase());
        }
    };
    /* List of file that starts with your given prefix */
    FTPFile[] ftpFiles = objFTPClient.listFiles(remoteDirectory, ftpFileFilter);
}catch(Exception ex){ 
    ex.printStackTrace();
}finally{
    //close connection, etc....
}