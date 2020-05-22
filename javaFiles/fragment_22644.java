import java.io.*;
import java.util.*;

public class Thing implements Serializable {
    private Map<String,String> map1;
    private Map<String,String> map2;

    public Thing() {
        this.map1 = new HashMap();
        this.map2 = this.map1; // Referring to same object
    }

    public void put(String key, String value) {
        this.map1.put(key, value);
    }

    public boolean mapsAreSameObject() {
        return this.map1 == this.map2;
    }
}