// client with explicit security, TLS protocol and tunneled over HTTP proxy
    FTPSHTTPClient ftps = new FTPSHTTPClient(<REMOVED_FOR_SERCURITY>, <REMOVED_FOR_SERCURITY>);
    // to show FTP commands in prompt
    ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
    // disable remote host verification
    ftps.setRemoteVerificationEnabled(false);
    // trust in ALL
    ftps.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
    // data transfer timeout
    ftps.setDataTimeout(1800000); // 30 

    // keepAlive - DON'T USE, HAS A BUG WITH HTTP PROXY - java.net.SocketTimeoutException: Read timed out
    //ftps.setControlKeepAliveTimeout(10l);

    // connect
    ftps.connect(<REMOVED_FOR_SERCURITY>, <REMOVED_FOR_SERCURITY>);
    ftps.login(<REMOVED_FOR_SERCURITY>, <REMOVED_FOR_SERCURITY>);

    // config
    ftps.setCharset(Charset.forName("UTF-8"));
    ftps.setBufferSize(0);
    ftps.execPROT("P");
    ftps.setFileType(FTP.BINARY_FILE_TYPE);
    ftps.enterLocalPassiveMode();

    // ... do some operations
    ftps.changeWorkingDirectory(<REMOVED_FOR_SERCURITY>);
    ftps.storeFile(<REMOVED_FOR_SERCURITY>, new FileInputStream(<REMOVED_FOR_SERCURITY>));

    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(<REMOVED_FOR_SERCURITY>));
    ftps.retrieveFile(<REMOVED_FOR_SERCURITY>, outputStream);
    outputStream.close();

    // close
    ftps.logout();
    ftps.disconnect();