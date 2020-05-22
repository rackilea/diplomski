public class Server{

    private History history;

    public void setHistory(History history){
        this.history = history;
    }

    public void someMethod(){
        this.history.addToHistoryArea();
    }
}