private ArrayBlockingQueue<String> writerQueue = new ArrayBlockingQueue<String>( 10 );
 private String stopSignal = "whatever";       

 public void stopWriter() { // this can safely called from other threads and will cause writer thread to stop
     writerQueue.put( stopSignal );     
 } 

 // this can also safely called from other threads
 public void sendMessage( String newMessage ) {
     writerQueue.put( newMessage );
 }

 @Override
 public void run() {
     String currentMessage = writerQueue.take(); // if there are no messages in queue this will block
     if( currentMessage == stopSignal ) // == comparison here is correct! we want to check for object equality 
         return; // stop signal received
     // write your string here
 }