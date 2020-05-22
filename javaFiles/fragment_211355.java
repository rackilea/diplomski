@XStreamAlias("row")
public class RecycleServices {

    @XStreamImplicit(itemFieldName = "row")
    private List<RecycleService> services = new ArrayList<RecycleService>();

    public List<RecycleService> getServices() {
        return services;
    }

    public void setServices(List<RecycleService> services) {
        this.services = services;
    }

}