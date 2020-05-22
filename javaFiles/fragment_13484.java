import java.util.HashMap;
import java.util.Map;

public class DoubleKeyMap<K1, K2, V>
{
    Map<K1, Map<K2, V>> mapOfMap;

    public void put(K1 key1, K2 key2, V value)
    {
        if (mapOfMap == null)
        {
            mapOfMap = new HashMap<K1, Map<K2, V>>();
        }

        if ( ! mapOfMap.containsKey(key1) )
        {
            mapOfMap.put(key1, new HashMap<K2, V>() );
        }

        mapOfMap.get(key1).put(key2, value);

    }

    public V get(K1 key1, K2 key2)
    {
        if ( ! mapOfMap.containsKey(key1) )
        {
            key1 = null;
        }
        if ( ! mapOfMap.get(key1).containsKey(key2) )
        {
            key2 = null;
        }
        return mapOfMap.get(key1).get(key2);
    }

    public static void main(String[] args)
    {
        DoubleKeyMap<String, String, Integer> bigMap = new DoubleKeyMap<String, String,Integer>();
        bigMap.put("A", null, 1);
        bigMap.put("A", "Z", 2);

        System.out.println( bigMap.get("A", null) );
        System.out.println( bigMap.get("A", "Z") );
        System.out.println( bigMap.get("A", "F") );
    }
}