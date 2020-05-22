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
        Map<String, List<String>> maps = null;
        maps = createTestCase0();
        //maps = createTestCase(5, 500);

        // output will go in mappings class
        List<Map<String, String>> mappings = generateMappings(maps);

        for (Map<String, String> mapping : mappings)
        {
            System.out.println(mapping);
        }
    }

    private static Map<String, List<String>> createTestCase(int numDataCenters, int numMachines)
    {
        Map<String, List<String>> maps = new LinkedHashMap<String, List<String>>();
        for (int i=0; i<numDataCenters; i++)
        {
            List<String> hosts = new ArrayList<String>();
            for (int j=0; j<numMachines; j++)
            {
                hosts.add("h"+j);
            }
            maps.put("dc"+i, hosts);
        }
        return maps;
    }

    private static Map<String, List<String>> createTestCase0()
    {
        List<String> hosts1 = Arrays.asList("h1", "h2", "h3");
        List<String> hosts2 = Arrays.asList("h1", "h2", "h3");
        List<String> hosts3 = Arrays.asList("h1", "h2", "h3");
        Map<String, List<String>> maps = new LinkedHashMap<String, List<String>>();
        maps.put("dc1", hosts1);
        maps.put("dc2", hosts2);
        maps.put("dc3", hosts3);
        return maps;
    }

    private static Map<String, List<String>> createTestCase1()
    {
        List<String> hosts1 = Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11");
        List<String> hosts2 = Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11");
        List<String> hosts3 = Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "h11");
        Map<String, List<String>> maps = new LinkedHashMap<String, List<String>>();
        maps.put("dc1", hosts1);
        maps.put("dc2", hosts2);
        maps.put("dc3", hosts3);
        return maps;
    }

    private static Map<String, List<String>> createTestCase2()
    {
        List<String> hosts1 = Arrays.asList("h1", "h2");
        List<String> hosts2 = Arrays.asList();
        List<String> hosts3 = Arrays.asList();
        Map<String, List<String>> maps = new LinkedHashMap<String, List<String>>();
        maps.put("dc1", hosts1);
        maps.put("dc2", hosts2);
        maps.put("dc3", hosts3);
        return maps;
    }

    private static Map<String, List<String>> createTestCase3()
    {
        List<String> hosts1 = Arrays.asList("h1", "h2", "h3"); 
        List<String> hosts2 = Arrays.asList("h1", "h2", "h3"); 
        List<String> hosts3 = Arrays.asList("h1", "h2", "h3", "h4", "h5");        
        Map<String, List<String>> maps = new LinkedHashMap<String, List<String>>();
        maps.put("dc1", hosts1);
        maps.put("dc2", hosts2);
        maps.put("dc3", hosts3);
        return maps;
    }




    public static List<Map<String, String>> generateMappings(
        Map<String, List<String>> input) 
    {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        List<String> dataCenters = new ArrayList<String>(input.keySet());

        Set<String> usedMachines = new LinkedHashSet<String>();
        Map<String, String> currentAssignment = new LinkedHashMap<String, String>();
        Map<String, Set<String>> usedMachinesForDataCenters =
            new LinkedHashMap<String, Set<String>>();

        while (true)
        {
            boolean generated = generateAssignments(
                input, dataCenters, 0, usedMachines, 
                usedMachinesForDataCenters, currentAssignment,
                output);
            if (!generated)
            {
                break;
            }
        };
        return output;
    }

    private static String indent(int n)
    {
        String s ="";
        for (int i=0; i<n; i++)
        {
            s += "  ";
        }
        return s;
    }

    private static boolean generateAssignments(
        Map<String, List<String>> input,
        List<String> dataCenters, 
        int dataCenterIndex,
         Set<String> usedMachines, 
        Map<String, Set<String>> usedMachinesForDataCenters,
        Map<String, String> currentAssignment,
        List<Map<String, String>> assignments)
    {
        //System.out.println(indent(dataCenterIndex)+"Computing assignment");

        if (dataCenterIndex >= dataCenters.size())
        {
            //System.out.println(indent(dataCenterIndex)+"Finished: "+currentAssignment);
            if (currentAssignment.size() == 0)
            {
                LinkedHashMap<String, String> assignment = 
                    new LinkedHashMap<String, String>(currentAssignment);
                assignments.add(assignment);
                return false;
            }

            for (String dataCenter : currentAssignment.keySet())
            {
                Set<String> usedMachinesForDataCenter = 
                    get(usedMachinesForDataCenters, dataCenter);
                usedMachinesForDataCenter.add(currentAssignment.get(dataCenter));
            }
            LinkedHashMap<String, String> assignment = 
                new LinkedHashMap<String, String>(currentAssignment);
            assignments.add(assignment);
            return true;
        }
        String dataCenter = dataCenters.get(dataCenterIndex);
        List<String> machinesForDataCenter = input.get(dataCenter);

        // Compute the machines that are available for the current data center.
        // That is, all machines except the ones that have already been used.
        List<String> availableMachinesForDataCenter = 
            new ArrayList<String>(machinesForDataCenter);
        Set<String> usedMachinesForDataCenter = 
            get(usedMachinesForDataCenters, dataCenter);
        availableMachinesForDataCenter.removeAll(usedMachines);
        availableMachinesForDataCenter.removeAll(usedMachinesForDataCenter);
        availableMachinesForDataCenter.add(null);

        //System.out.println(indent(dataCenterIndex)+"Assign any of "+availableMachinesForDataCenter+" to "+dataCenter);

        // Try to assign each of the available machines to the current
        // data center, and do the recursion
        for (String machine : availableMachinesForDataCenter)
        {
            //System.out.println(indent(dataCenterIndex)+"Assign "+machine+" to "+dataCenter);

            // Store the current mapping, and remember that the
            // machine was already used
            if (machine != null)
            {
                currentAssignment.put(dataCenter, machine);
                usedMachines.add(machine);
            }

            // Do the recursion
            boolean generated = generateAssignments(
                input, dataCenters, dataCenterIndex+1, usedMachines, 
                usedMachinesForDataCenters, currentAssignment,
                assignments);

            // Undo the assignment 
            currentAssignment.remove(dataCenter);
            usedMachines.remove(machine);

            if (generated)
            {
                return true;
            }
        }
        return false;
    }    


    private static <K, V> Set<V> get(Map<K, Set<V>> map, K key)
    {
        Set<V> set = map.get(key);
        if (set == null)
        {
            set = new LinkedHashSet<V>();
            map.put(key, set);
        }
        return set;
    }
}