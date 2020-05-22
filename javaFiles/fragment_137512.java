import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MergeListsTest
{
    public static void main(String[] args)
    {
        List<Set<String>> sets = new ArrayList<Set<String>>();
        sets.add(new LinkedHashSet<String>(Arrays.asList("A", "B")));
        sets.add(new LinkedHashSet<String>(Arrays.asList("C", "D")));
        sets.add(new LinkedHashSet<String>(Arrays.asList("B", "C")));
        sets.add(new LinkedHashSet<String>(Arrays.asList("E", "F")));
        //sets.add(new LinkedHashSet<String>(Arrays.asList("D")));
        //sets.add(new LinkedHashSet<String>(Arrays.asList("D", "X")));
        //sets.add(new LinkedHashSet<String>());

        Collection<Set<String>> merged = computeMerged(sets);

        System.out.println("Resulting sets:");
        for (Set<String> s : merged)
        {
            System.out.println(s);
        }
    }

    private static <T> Collection<Set<T>> computeMerged(List<Set<T>> sets)
    {
        Map<T, Set<T>> compactMap = new LinkedHashMap<T, Set<T>>();
        Map<T, Set<T>> map = new LinkedHashMap<T, Set<T>>();
        for (Set<T> set : sets)
        {
            System.out.println("Handle set "+set);

            Set<T> combinedSet = new LinkedHashSet<T>(set);
            for (T t : set)
            {
                Set<T> innerSet = map.get(t);
                if (innerSet != null && !innerSet.isEmpty())
                {
                    System.out.println("Element "+t+" was previously mapped to "+innerSet);

                    T first = innerSet.iterator().next();
                    compactMap.remove(first);
                    combinedSet.addAll(innerSet);

                    System.out.println("Combined set is now "+combinedSet);
                }
            }
            if (!combinedSet.isEmpty())
            {
                System.out.println("Store a mapping from each element in "+combinedSet+" to this set");
                T first = combinedSet.iterator().next();
                compactMap.put(first, combinedSet);
                for (T t : combinedSet)
                {
                    map.put(t, combinedSet);
                }
            }
        }
        return compactMap.values();
    }

}