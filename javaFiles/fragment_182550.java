public void run()
  {
     toClient.println(mesg);
     try {
        //toClient.close();
        //client.close();
     }
     catch (Exception e)  {
        e.printStackTrace();
     }
  }