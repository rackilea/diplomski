public class Buy {
    private ObserverImp observer;
    private CloseableHttpClient httpClient;

    public Buy (ObserverImp observer, CloseableHttpClient httpClient) {
       this.observer = observer;
       this.httpClient = httpClient;
    }

    public void buy(double price) {
       ...

       // Comment or remove the line below and use the injected instead...
       // CloseableHttpClient httpClient = HttpClients.createDefault();

       ...
    }
}