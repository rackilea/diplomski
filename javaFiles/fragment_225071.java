public class HTTPClientProxy{

    private final Object syncLock = new Object();

    private HTTPClient client;

    public HTTPClient getClient(){
        synchronized(syncLock){
            return client;
        }
    }

    public void updateClient(URL url){
        synchronized(syncLock){
            client = new HTTPClient(url);
        }
    }
}