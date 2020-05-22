public class Server{

    private History history;

    public Server(History history){
        this.history = history;
    }

    public void someMethod(){
        this.history.addToHistoryArea();
    }
}