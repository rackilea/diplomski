// check FTP login
if (ftpClient.login(ftpsUser, ftpsPass)){
    ftpClient.enterLocalPassiveMode();
    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
    System.out.println("Logged into FTP server successfully");
} else {
    System.out.println("Failed log into FTP server");
    ftpClient.logout();
    ftpClient.disconnect();
    return;
}