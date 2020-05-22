import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;


public class DatacenterMappingTest
{
    public static void main(String[] args)
    {
        //        List<String> hosts1 = Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11");
        //        List<String> hosts2 = Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11");
        //        List<String> hosts3 = Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11");
        //
        //        or
        //        
        //        List<String> hosts1 = Arrays.asList("h1", "h2", "h3");
        //        List<String> hosts2 = Arrays.asList("h1", "h2", "h3");
        //        List<String> hosts3 = Arrays.asList("h1", "h2", "h3");
        //
        //        or
        //
        //        List<String> hosts1 = Arrays.asList("h1", "h2");
        //        List<String> hosts2 = Arrays.asList();
        //        List<String> hosts3 = Arrays.asList();

        List<String> hosts1 = Arrays.asList("h1", "h2", "h3"); 
        List<String> hosts2 = Arrays.asList("h1", "h2", "h3"); 
        List<String> hosts3 = Arrays.asList("h1", "h2", "h3", "h4", "h5");        

        Map<String, List<String>> maps = new LinkedHashMap<String, List<String>>();
        maps.put("dc1", hosts1);
        maps.put("dc2", hosts2);
        maps.put("dc3", hosts3);

        // output will go in mappings class
        List<Map<String, String>> mappings = generateMappings(maps);            

        for (Map<String, String> mapping : mappings)
        {
            System.out.println(mapping);
        }
    }

    public static List<Map<String, String>> generateMappings(Map<String, List<String>> input)
    {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        List<List<String>> inputValues = new ArrayList<List<String>>();
        for (List<String> inputValue : input.values())
        {
            List<String> extendedInputValue = new ArrayList<String>(inputValue);
            extendedInputValue.add(null);
            inputValues.add(extendedInputValue);
        }
        List<String> dataCenters = new ArrayList<String>(input.keySet());
        Map<String, Set<String>> usedMachinesForDataCenters =
            new LinkedHashMap<String, Set<String>>();
        MixedRangeCombinationIterable<String> iterable = 
            new MixedRangeCombinationIterable<String>(inputValues);        
        for (List<String> machines : iterable)
        {
            if (isValid(dataCenters, machines, usedMachinesForDataCenters))
            {
                Map<String, String> assignment = createMap(dataCenters, machines);
                output.add(assignment);
                store(dataCenters, machines, usedMachinesForDataCenters);
            }
        }
        return output;
    }

    private static Map<String, String> createMap(List<String> dataCenters, List<String> machines)
    {
        Map<String, String> result = new LinkedHashMap<String, String>();
        for (int i=0; i<machines.size(); i++)
        {
            String machine = machines.get(i);
            if (machine != null)
            {
                String dataCenter = dataCenters.get(i);
                result.put(dataCenter, machine);
            }
        }
        return result;
    }

    private static void store(List<String> dataCenters, List<String> machines, 
        Map<String, Set<String>> usedMachinesForDataCenters)
    {
        for (int i=0; i<machines.size(); i++)
        {
            String machine = machines.get(i);
            if (machine != null)
            {
                String dataCenter = dataCenters.get(i);
                Set<String> usedMachinesForDataCenter =
                    get(usedMachinesForDataCenters, dataCenter);
                usedMachinesForDataCenter.add(machine);
            }
        }
    }

    private static boolean isValid(List<String> dataCenters, List<String> machines, 
        Map<String, Set<String>> usedMachinesForDataCenters)
    {
        for (String machine : machines)
        {
            if (machine != null)
            {
                if (Collections.frequency(machines, machine) > 1)
                {
                    return false;
                }
            }
        }
        for (int i=0; i<machines.size(); i++)
        {
            String machine = machines.get(i);
            if (machine != null)
            {
                String dataCenter = dataCenters.get(i);
                Set<String> usedMachinesForDataCenter =
                    get(usedMachinesForDataCenters, dataCenter);
                if (usedMachinesForDataCenter.contains(machine))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static Set<String> get(Map<String, Set<String>> map, String key)
    {
        Set<String> result = map.get(key);
        if (result == null)
        {
            result = new LinkedHashSet<String>();
            map.put(key, result);
        }
        return result;
    }
}


/**
* A class providing an iterator over all combinations of a certain number
* of elements, where the valid ranges may be different for each element
* of the combination. For a set S = { S0, S1, ... Sn } there will be
* |S0| * |S1| * ... * |Sn| possible combinations. Example:<br />
* <pre>
* S0 = {A,B,C}, |S0| = 3
* S1 = {D,E} , |S1| = 2
* S2 = {A,E} , |S2| = 2
* S = { S0, S1, S2 }
* m = |S0| * |S1| * |S0| = 3 * 2 * 2 = 12 combinations
*
* Combinations:
* [A, D, A]
* [A, D, E]
* [A, E, A]
* [A, E, E]
* [B, D, A]
* [B, D, E]
* [B, E, A]
* [B, E, E]
* [C, D, A]
* [C, D, E]
* [C, E, A]
* [C, E, E]
* </pre>
*
* @param <T> The type of the elements
*/class MixedRangeCombinationIterable<T> implements Iterable<List<T>>
{
    /**
     * The input elements
     */
    private List<? extends Collection<? extends T>> sets;

    /**
     * The total number of elements that the iterator will provide
     */
    private final int numElements;

    /**
     * Creates an iterable over all combinations of one element
     * of each of the given sets.
     *
     * @param sets The input sets
     */
    public MixedRangeCombinationIterable(
        List<? extends Collection<? extends T>> sets)
    {
        this.sets = sets;
        int m = 0;
        if (sets.size() > 0)
        {
            m = 1;
        }
        for (Collection<? extends T> set : sets)
        {
            m *= set.size();
        }
        this.numElements = m;
    }

    @Override
    public Iterator<List<T>> iterator()
    {
        return new Iterator<List<T>>()
        {
            /**
             * The element counter
             */
            private int current = 0;

            /**
             * The current combination
             */
            private List<T> currentCombination = new ArrayList<T>();

            /**
             * The iterators over the individual sets
             */
            private List<Iterator<? extends T>> subIterators =
                new ArrayList<Iterator<? extends T>>(
                    Collections.<Iterator<? extends T>>nCopies(
                        sets.size(), null));

            // Initialize the sub-iterators and the first combination
            {
                if (numElements > 0)
                {
                    for (int i=0; i<sets.size(); i++)
                    {
                        Iterator<? extends T> subIterator =
                            sets.get(i).iterator();
                        subIterators.set(i, subIterator);
                        currentCombination.add(subIterator.next());
                    }
                }
            }

            @Override
            public boolean hasNext()
            {
                return current < numElements;
            }

            @Override
            public List<T> next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException("No more elements");
                }

                List<T> result = new ArrayList<T>(currentCombination);
                increase(sets.size()-1);
                current++;
                return result;
            }

            /**
             * Increases the selection of elements by one.
             *
             * @param index The index to increase
             */
            private void increase(int index)
            {
                if (index < 0)
                {
                    return;
                }
                Iterator<? extends T> subIterator = subIterators.get(index);
                if (subIterator.hasNext())
                {
                    currentCombination.set(index, subIterator.next());
                }
                else
                {
                    subIterator = sets.get(index).iterator();
                    subIterators.set(index, subIterator);
                    currentCombination.set(index, subIterator.next());
                    increase(index-1);
                }

            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException(
                    "May not remove elements from a combination");
            }
        };
    }
}