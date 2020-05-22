public class WaitServer extends Thread {

    synchronized void serverCompleted() {
        // when server completes
        notify();

    }

    @Override
    public synchronized void start() {

        try {
            wait(); // waits the server
        } catch (InterruptedException e) {                      

        }       
    }   
}
class ClientSide {

    void doSomething() {

        // ... some stuff ....      
        sendToServer();

        new WaitServer().join();

        // continues execution      
    }   
}

class ServerSide {
    void received() {

        // ... do some stuff .....

        if (someStuff) {            
            sendSignalToClient();

        }       
        // .. others stuff          
    }

    void sendSignalToClient() {     
        // here of course you need to send in the way that you are sending today, this is "pseudocode"
        client.serverCompleted()        
    }       
}