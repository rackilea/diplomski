import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AllPairs
{
    public static void main(String[] args)
    {
        Set<Integer> set = new LinkedHashSet<Integer>(
            Arrays.asList(1,2,3,4,5,6));

        ArrayList<List<List<Integer>>> results = 
            new ArrayList<List<List<Integer>>>();
        compute(set, new ArrayList<List<Integer>>(), results);
        for (List<List<Integer>> result : results)
        {
            System.out.println(result);
        }
    }

    private static void compute(Set<Integer> set,
        List<List<Integer>> currentResults,
        List<List<List<Integer>>> results)
    {
        if (set.size() < 2)
        {
            results.add(new ArrayList<List<Integer>>(currentResults));
            return;
        }
        List<Integer> list = new ArrayList<Integer>(set);
        Integer first = list.remove(0);
        for (int i=0; i<list.size(); i++)
        {
            Integer second = list.get(i);
            Set<Integer> nextSet = new LinkedHashSet<Integer>(list);
            nextSet.remove(second);

            List<Integer> pair = Arrays.asList(first, second);
            currentResults.add(pair);
            compute(nextSet, currentResults, results);
            currentResults.remove(pair);
        }
    }
}