boolean error = false;
    try {
      int reply;
      ftp.connect("ftp.foobar.com");
      System.out.println("Connected to " + server + ".");
      System.out.print(ftp.getReplyString());

      // After connection attempt, you should check the reply code to verify
      // success.
      reply = ftp.getReplyCode();

      if(!FTPReply.isPositiveCompletion(reply)) {
        ftp.disconnect();
        System.err.println("FTP server refused connection.");
        System.exit(1);
      }
      ... // transfer files
      ftp.logout();
    } catch(IOException e) {
      error = true;
      e.printStackTrace();
    } finally {
      if(ftp.isConnected()) {
        try {
          ftp.disconnect();
        } catch(IOException ioe) {
          // do nothing
        }
      }
      System.exit(error ? 1 : 0);
    }