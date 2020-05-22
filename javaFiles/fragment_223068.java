import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class GreatestOfMap
{
    public static void main(String[] args)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("zip000", 1234);
        map.put("zip001", 2345);
        map.put("zip002", 3456);
        map.put("zip003", 4567);
        map.put("zip004", 5678);
        map.put("zip005", 6789);
        map.put("zip006", 123);
        map.put("zip007", 234);
        map.put("zip008", 456);
        map.put("zip009", 567);
        map.put("zip010", 7890);
        map.put("zip011", 678);
        map.put("zip012", 789);
        map.put("zip013", 890);

        int n = 5;
        List<Entry<String, Integer>> greatest = findGreatest(map, 5);
        System.out.println("Top "+n+" entries:");
        for (Entry<String, Integer> entry : greatest)
        {
            System.out.println(entry);
        }
    }

    private static <K, V extends Comparable<? super V>> List<Entry<K, V>> 
        findGreatest(Map<K, V> map, int n)
    {
        Comparator<? super Entry<K, V>> comparator = 
            new Comparator<Entry<K, V>>()
        {
            @Override
            public int compare(Entry<K, V> e0, Entry<K, V> e1)
            {
                V v0 = e0.getValue();
                V v1 = e1.getValue();
                return v0.compareTo(v1);
            }
        };
        PriorityQueue<Entry<K, V>> highest = 
            new PriorityQueue<Entry<K,V>>(n, comparator);
        for (Entry<K, V> entry : map.entrySet())
        {
            highest.offer(entry);
            while (highest.size() > n)
            {
                highest.poll();
            }
        }

        List<Entry<K, V>> result = new ArrayList<Map.Entry<K,V>>();
        while (highest.size() > 0)
        {
            result.add(highest.poll());
        }
        return result;
    }
}