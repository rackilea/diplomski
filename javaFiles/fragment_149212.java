import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortByName
{
    public static void main(String[] args)
    {
        Integer input[] = { 1,22,44,3456,9999};
        final String array[] = { 
            "one", "twotwo", "fourfour", "threefourfivesix", 
            "ninenineninenine"};

        final Map<Integer, String> map = createMap(input, array);
        Arrays.sort(input, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer i0, Integer i1)
            {
                return map.get(i0).compareTo(map.get(i1));
            }

        });
        System.out.println(Arrays.toString(input));
    }

    private static <K, V> Map<K, V> createMap(K k[], V v[])
    {
        Map<K, V> map = new LinkedHashMap<K, V>();
        for (int i=0; i<k.length; i++)
        {
            map.put(k[i], v[i]);
        }
        return map;
    }
}