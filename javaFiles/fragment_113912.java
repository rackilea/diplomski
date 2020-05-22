while(!Thread.currentThread().isInterrupted()) {  

/* Interrupt the current thread if socket connection is broken. 
   This will interrupt the thread and the condition in the while loop will become false.  
   Hence, your loop will exit normally. */  

    if(socket.isClosed())
        Thread.currentThread().interrupt();  
}