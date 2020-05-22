import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CriterionFilter
{
    public static void main(String[] args)
    {
        List<Emp> list = new ArrayList<Emp>();
        list.add(new Emp(10,"Anitha",1000,"AE"));
        list.add(new Emp(20,"Chaitanya",2000,"SE"));
        list.add(new Emp(30,"Chaitanya",3000,"SE"));
        list.add(new Emp(40,"Deepthi",2100,"AE"));
        list.add(new Emp(50,"Deepthi",2200,"CE"));
        list.add(new Emp(60,"Deepthi",2300,"BE"));
        list.add(new Emp(70,"Anitha",2300,"BE"));
        list.add(new Emp(80,"Anitha",2400,"ME"));
        list.add(new Emp(90,"Sita",2200,"CE"));
        list.add(new Emp(100,"Hari",2200,"CE"));
        list.add(new Emp(110,"Krishna",2200,"CE"));

        Function<Emp, String> keyFunction = new Function<Emp, String>()
        {
            @Override
            public String apply(Emp s)
            {
                return s.getName();
            }
        };
        List<Emp> fiteredOnUnique = filterOnUnique(list, keyFunction);
        System.out.println("Filtered on unique:");
        print(fiteredOnUnique);

        List<Emp> filteredOnSame = filterOnSame(list, keyFunction);
        System.out.println("Filtered on same:");
        print(filteredOnSame);
    }

    private static void print(Iterable<?> elements)
    {
        for (Object element : elements)
        {
            System.out.println(element);
        }
    }

    /**
     * Create a map that maps the keys that are provided for the given
     * elements to the list of elements that have this key
     *
     * @param elements The input elements
     * @param keyFunction The key function
     * @return The map
     */
    private static <T, K> Map<K, List<T>> map(
        Iterable<? extends T> elements, Function<? super T, K> keyFunction)
    {
        Map<K, List<T>> map = new HashMap<K, List<T>>();
        for (T t : elements)
        {
            K key = keyFunction.apply(t);
            List<T> list = map.get(key);
            if (list == null)
            {
                list = new ArrayList<T>();
                map.put(key, list);
            }
            list.add(t);
        }
        return map;
    }

    /**
     * Uses the given key function to compute the keys associated with the
     * given elements, and returns a list containing the element of
     * the given sequence that have unique keys
     *
     * @param elements The input elements
     * @param keyFunction The key function
     * @return The filtered list
     */
    private static <T, K> List<T> filterOnUnique(
        Iterable<? extends T> elements, Function<? super T, K> keyFunction)
    {
        List<T> result = new ArrayList<T>();
        Map<K, List<T>> map = map(elements, keyFunction);
        for (Entry<K, List<T>> entry : map.entrySet())
        {
            List<T> list = entry.getValue();
            if (list.size() == 1)
            {
                result.add(list.get(0));
            }
        }
        return result;
    }

    /**
     * Uses the given key function to compute the keys associated with the
     * given elements, and returns a list containing all elements of
     * the given sequence that have a key that occurs multiple times.
     *
     * @param elements The input elements
     * @param keyFunction The key function
     * @return The filtered list
     */
    private static <T, K> List<T> filterOnSame(
        Iterable<? extends T> elements, Function<? super T, K> keyFunction)
    {
        List<T> result = new ArrayList<T>();
        Map<K, List<T>> map = map(elements, keyFunction);
        for (Entry<K, List<T>> entry : map.entrySet())
        {
            List<T> list = entry.getValue();
            if (list.size() > 1)
            {
                result.addAll(list);
            }
        }
        return result;
    }



    /**
     * Interface for a generic function
     */
    static interface Function<S, T>
    {
        T apply(S s);
    }

}


class Emp
{
    private int i;
    private String name;
    private int j;
    private String whatever;

    public Emp(int i, String name, int j, String whatever)
    {
        this.i = i;
        this.name = name;
        this.j = j;
        this.whatever = whatever;
    }

    @Override
    public String toString()
    {
        return "Emp [i=" + i + ", name=" + name + ", j=" + j + ", whatever=" + whatever + "]";
    }

    String getName()
    {
        return name;
    }
}