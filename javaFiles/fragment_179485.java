package sirmagid;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author @sirmagid
 */
public class sort_multi_by_int {


    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

    // 1. Convert Map to List of Map
    List<Map.Entry<String, Integer>> list =
            new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

    // 2. Sort list with Collections.sort(), provide a custom Comparator
    //    Try switch the o1 o2 position for a different order
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> o1,
                           Map.Entry<String, Integer> o2) {
            return (o2.getValue()).compareTo(o1.getValue());
        }
    });

    // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
    Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> entry : list) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    /*
    //classic iterator example
    for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
        Map.Entry<String, Integer> entry = it.next();
        sortedMap.put(entry.getKey(), entry.getValue());
    }*/


    return sortedMap;
}

public static <K, V> void printMap(Map<K, V> map) {
    for (Map.Entry<K, V> entry : map.entrySet()) {
        System.out.println("Key : " + entry.getKey()
                + " Value : " + entry.getValue());
    }
}

}





package sirmagid;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.stream.Collectors;

/**
 *
 * @author @sirmagid
 */
public class Sampel {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    // TODO code application logic here
//Map<String, Map<String, Integer>> map = new HashMap<>();
//Map<String, Integer> data = new HashMap<>();    
Multimap<String, Integer> data = ArrayListMultimap.create();
data.put("Alex", 10);
data.put("Tom", 20);
data.put("Tom", 20);
data.put("John", 30);
data.put("John", 31);


for (Map.Entry entry : data.entries())// entrySet())
{    
    //System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
}

HashMap<String, Integer> resultMap = new HashMap<String, Integer>();

    Set<String> keys = data.keySet();
    for(String key : keys){
        Collection<Integer> coll = (Collection<Integer>) data.get(key);
        int sum = 0;
        for(Integer i : coll){
            sum += i;
        }
        resultMap.put(key, sum);
    }



    for (Map.Entry entry : resultMap.entrySet())
{    
    System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
}

  System.out.println("--------------------------------------");
  sort_multi_by_int sort = new sort_multi_by_int();
 // sort.printMap (sort.sortByValue(resultMap));

       for (Map.Entry<String, Integer> entry : sort.sortByValue(resultMap).entrySet()) {
        System.out.println("Key : " + entry.getKey()
                + " Value : " + entry.getValue());
    }



}




 public Multimap<String, String> sortedByDescendingFrequency(Multimap<String, String> multimap) {
return ImmutableMultimap.<String, String>builder()
        .orderKeysBy(descendingCountOrdering(multimap.keys()))
        .putAll(multimap)
        .build();
}



private static Ordering<String> descendingCountOrdering(final Multiset<String>  multiset) {
 return new Ordering<String>() {
    @Override
    public int compare(String left, String right) {
        return Ints.compare(multiset.count(left), multiset.count(right));
    }
};
}

}