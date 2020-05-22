public class Pojo{

private String id;

private Map<String, Object> data = new HashMap<String, Object>();

public Object get(String name){
    return data.get(name);
}

public void set(String name, Object value){
    data.put(name, value);
}

}