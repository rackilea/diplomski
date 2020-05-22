class Data {
    private Long id;//Unique id of Object by using some strategy to allocate unique 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

public class DataUtils {

    //Created only once for whole application
    private static final Map<Long, Data> DATA_MAP = new HashMap<Long, Data>();

    public void addObjectToMap(Data data) {
        DATA_MAP.put(data.getId(), data);
    }

    public Data getData(Long id) {
        return DATA_MAP.get(id);
    }

}