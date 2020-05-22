private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException{                                         
      //create a GreetingServer object and call the method you want in the
      //GreetingServer.java using dot(.) operator like for example,
      GreetingServer gServer = new GreetingServer(9000);
      gServer.run();
}