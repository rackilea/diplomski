FTPClient ftp = new FTPClient();
ftp.connect("ftp.example.com");
ftp.login("admin", "secret");
ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

for(File file : files) {
    InputStream in = new FileInputStream(file);
    ftp.storeFile(file.getName(), in);
    in.close();
}

ftp.disconnect();