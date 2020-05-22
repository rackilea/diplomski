@ManagedBean
public class GeneralMapBacking {

    @ManagedProperty("#{map}")
    private Map<Object, Object> map;

    public void onPreRenderView() {
        map.put("foo", "bar");
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }  
}