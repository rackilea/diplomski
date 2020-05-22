@Singleton
public class MyBean {

    private Client client;

    @PostConstruct
    public void onCreate() {
        this.client = ClientBuilder.newClient();
    }

    ...

    @PreDestroy
    public void onDestroy() {
        this.client.close();
    }
}