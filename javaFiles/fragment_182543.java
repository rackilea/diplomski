InputStream filein = new FileInputStream(new File("/path/to/file.txt"));

            // create url
    FTPClient ftp = new FTPClient();
    ftp.connect(host);
    ftp.login(user, pass);

    int reply = ftp.getReplyCode();
    if(!FTPReply.isPositiveCompletion(reply)) {
        ftp.disconnect();
        System.err.println("FTP server refused connection.");
        return;
    }

    OutputStream ftpout = ftp.appendFileStream("text.txt");

    // write file
    byte[] data = new byte[1024];
    int len = 0;

    while((len = filein.read(data)) > 0) {
        ftpout.write(data,0, len);
    }

    filein.close();
    ftpout.close();
    ftp.logout();