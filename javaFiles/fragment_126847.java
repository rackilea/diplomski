class Networking 
{
    public synchronized Status getStatus() {
        Status stat =  new Status();
        // ...
        // Get status logic
        // ...
        return stat;// return the status
    }

    public synchronized void sendMessage(Message msg) {
        // ...
        // Send the message logic
        // ...
    }
}