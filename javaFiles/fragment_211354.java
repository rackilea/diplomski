@XStreamAlias("response")
public class QueryResponse {

    @XStreamAlias("row")
    private RecycleServices services;

    public RecycleServices getServices() {
        return services;
    }

    public void setServices(RecycleServices services) {
        this.services = services;
    }

}