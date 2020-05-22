public class TakeOrder implements Runnable {

    Socket SOCK;
    Controller controller;

    //OrderIndexes: "Order","Waiter","Payment"

    private int NonConnectedDatas = 2;

    public TakeOrder(Socket X, Controller controller){
        this.SOCK = X;
        this.controller = controller ;
    }

    // ...

    public void run() {

        // ...

        Platform.runLater(controller::createBill);

        // ...
    }

}