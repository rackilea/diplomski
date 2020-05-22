clientOutputStreams = new ArrayList(); //Subscribers list
...
...
 public void tellEveryone(String message) {  //Publish your message writing it in each single outPutStream
     Iterator it = clientOutputStreams.iterator(); //Get an iterator to traverse the subscriber list
     while(it.hasNext()) { 
         try {
             PrintWriter writer = (PrintWriter) it.next();
             writer.println(message); //Print the message.
             writer.flush();
         } catch(Exception ex){ex.printStackTrace();} //Catch any posssible exception, (what happens if one stream is closed?)
     }//end while
 }//end method