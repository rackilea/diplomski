import java.util.HashMap;
import java.util.Map;

public class MyType {

    static Map<Integer, MyType> idMap = new HashMap<>();
    static {
        idMap.put(10, new MyType("First Type"));
        idMap.put(20, new MyType("Second Type"));
    }

    private final String name;

    private MyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MyType byId(Integer id) {
        return idMap.get(id);
    }

    public static void addType(String name, Integer id) {
        MyType lookup = byId(id);
        if(lookup != null) {
            if(!lookup.getName().equals(name)) {
                System.out.println("conflicting redefinition for id " + id + ": '" + name + "' vs '" + lookup.name + "'");
                //handle...
            }
        }
        idMap.put(id, new MyType(name));
    }
}