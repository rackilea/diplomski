import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapInvert
{
    public static void main(String[] args)
    {
        Map<Integer, Set<String>> map = 
            new LinkedHashMap<Integer, Set<String>>();

        map.put(1, new LinkedHashSet<String>(Arrays.asList("A","B","C")));
        map.put(2, new LinkedHashSet<String>(Arrays.asList("D","E","F")));
        map.put(3, new LinkedHashSet<String>(Arrays.asList("G","H","I")));

        Map<String, Integer> resultA = inverseEx(map);
        System.out.println("Procedural: "+resultA);

        Map<String, Integer> resultB = map.entrySet().stream().collect(
            LinkedHashMap::new, 
            (m, e) -> e.getValue().forEach(v -> m.put(v, e.getKey())), 
            (m0, m1) -> m0.putAll(m1));
        System.out.println("Functional: "+resultB);
    }

    /**
     * Invert the given map, by mapping each element of the values to
     * the respective key
     *  
     * @param map The input map
     * @return The inverted map
     */
    private static <K, V> Map<V, K> inverseEx(
        Map<K, ? extends Collection<? extends V>> map)
    {
        Map<V, K> result = new LinkedHashMap<V, K>();
        for (Entry<K, ? extends Collection<? extends V>> e : map.entrySet())
        {
            for (V v : e.getValue())
            {
                result.put(v, e.getKey());
            }
        }
        return result;
    }
}