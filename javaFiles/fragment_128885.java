class GmailReceiver {
  public void receive() {
    AccessMailMessages readGmail = new AccessMailMessages();
    GmailConfiguration config = GmailConfiguration.INSTANCE;
    config.configure();
    readGmail.recieveGmail(config.getName(),
        config.getHost(), 
        config.getPort() /* etc */);

  }
}