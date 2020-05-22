import java.util.HashMap;
import java.util.Map;


public class MapReturn<K,V> extends HashMap<K,V>{

    public static void main (String [] args){

    }

    public Map.Entry<K,V> returnMapValue(K k, V v){

        return new java.util.AbstractMap.SimpleEntry<K,V>(k,v);
    }

}