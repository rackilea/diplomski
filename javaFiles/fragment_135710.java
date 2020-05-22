public class ConnectionHandling implements Runnable{

    private final Controller controller ;

    public ConnectionHandling(Controller controller) {
        this.controller = controller ;
    }

    // ...

    public void run(){

        // existing code ...

        TakeOrder ORDER = new TakeOrder(SOCK, connection);

        // ...
    }
}