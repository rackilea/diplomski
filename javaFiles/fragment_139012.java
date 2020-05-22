public class mySendingThread extends Thread{
private BlockingQueue<String> toSendMessages= new BlockingQueue<>();

Public mySendingThread (BlockingQueue<String> toSendMessages){
this.toSendMessages = toSendMessages;
}

@Override
        public void run(){
            while(myAppisRunnung == true){
             String message= toSendMessages.take();
//Send message
}
}
}