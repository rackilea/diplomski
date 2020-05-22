class Networking 
{
    private static final Object lock = new Object();

    public synchronized Status getStatus() {
        synchronized(lock){
            Status stat =  new Status();
            // ...
            // Get status logic
            // ...
            return stat;// return the status
        }
    }

    public synchronized void sendMessage(Message msg) {
        synchronized(lock){
            // ...
            // Send the message logic
            // ...
        }
    }
}