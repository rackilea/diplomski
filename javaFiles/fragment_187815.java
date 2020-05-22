@Named
@ApplicationScoped
public class ApplicationScopedBean {
    private Map<KeyClass, ValueClass> map;
    @PostConstruct
    public void init() {
        //initialize the map and its data here
        map = new ConcurrentHashMap<>();
        map.put(..., ...);
        //...
    }
    //provide a getter for the map
    public Map<KeyClass, ValueClass> getMap() {
        return this.map;
    }
}