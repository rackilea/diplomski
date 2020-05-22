// File dfile
FTPFile[] files = ftpClient.listFiles();
for (FTPFile file : files) {
    if (file.getName().contains(".zip")) {
    dfile = file;
    }
}
...
File downloadPath = new File(homePath + "\\Buildss\\" + osVer);
...
// File downloadFile;
downloadFile = new File(downloadPath + "/" + dfile);