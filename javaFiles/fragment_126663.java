XMPPConnection.DEBUG_ENABLED = false;
config.setCompressionEnabled(true);
config.setSASLAuthenticationEnabled(false);


private void connectionInit() throws XMPPException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("... in main function .......");
    XMPPConnection.DEBUG_ENABLED = false;
    mySmackObj = new NSmackAPI();
    boolean status = mySmackObj.connectTOGTalk();
    boolean initial_status = true;
    mySmackObj.displayUserList();
    System.out.println("-----");

    String talkTo=RunMTNew.customer+"web@"+server;
    System.out.println(talkTo);
    System.out.println("-----");
    System.out.println("All messages will be sent to " + talkTo);
    System.out.println("Enter your message in the console:");
    System.out.println("-----\n");
    mySmackObj.sendMessage("Hi..are you there", talkTo);
  try{
      while(!(smsg=br.readLine()).equals(null)){
          mySmackObj.sendMessage(smsg, talkTo);
      }
  }
  catch(Exception e){
      System.out.println("sending failed");
      e.printStackTrace();
  }

}

boolean connectTOGTalk() throws XMPPException{

    try {


        ConnectionConfiguration config = new ConnectionConfiguration(server, 5222, server);
        config.setCompressionEnabled(true);
        config.setSASLAuthenticationEnabled(false);
        connection = new XMPPConnection(config);
        connection.connect();
        System.out.println("Username is "+username);
        System.out.println("Connected to " + connection.getHost());
        connection.login(username,password);
        System.out.println(connection.isAuthenticated());
        }
    catch (Exception e) {
        e.printStackTrace();
    }
    if(connection.isConnected()){
        return true;
    }
    else {
        return false;
    }
}