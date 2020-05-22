import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import localhost.ValueComparator;


public class App 
{
    public static void main( String[] args )
    {

        // create a list to store our original data
        ArrayList<HashMap<String, String>> keyValuePairs = new ArrayList<HashMap<String,String>>();

        // add the data to the list
        HashMap<String, String> a = new LinkedHashMap<String, String>();
        a.put("a", "1"); a.put("b", "1"); a.put("c", "1"); a.put("d", "1"); a.put("f", "1"); a.put("g", "1"); a.put("h", "1"); a.put("i", "1"); a.put("j", "1");
        keyValuePairs.add(a);

        HashMap<String, String> e = new LinkedHashMap<String, String>();
        e.put("a", "1"); e.put("b", "1"); e.put("d", "1"); e.put("e", "1"); e.put("f", "1"); e.put("h", "1"); e.put("i", "1"); e.put("j", "1");
        keyValuePairs.add(e);

        HashMap<String, String> b = new LinkedHashMap<String, String>();
        b.put("a", "1"); b.put("b", "1"); b.put("c", "1"); b.put("d", "1"); b.put("e", "1"); b.put("f", "1"); b.put("j", "1"); b.put("k", "1"); b.put("l", "1");
        keyValuePairs.add(b);

        HashMap<String, String> c = new LinkedHashMap<String, String>();
        c.put("a", "1"); c.put("b", "1"); c.put("x", "1"); c.put("d", "1"); c.put("e", "1"); c.put("f", "1"); c.put("g", "1"); c.put("h", "1"); c.put("m", "1");
        keyValuePairs.add(c);

        // create a map to store the max and min indices
        Map<String, Integer[]> m = new HashMap<String, Integer[]>();

        Integer curpos = new Integer(0);

        // loop through the data and find the max and min indices of each data (key)
        for ( Map<String,String> s : keyValuePairs) {
            curpos = 0;
            for ( String t : s.keySet() ) {

                if ( !m.containsKey(t) ){
                    // if its the first time to see the data, just add its current index as max and min
                    m.put(t,new Integer[] {curpos, curpos});

                }
                else {
                    // check if index is lower than existing minimum
                    Integer[] i = m.get(t);
                    if ( i[0] > curpos) {
                        m.put(t, new Integer[] {curpos, i[1]});
                    }
                    //check if index is greater than current maximum
                    if ( curpos > i[1] ) {
                        m.put(t, new Integer[] {i[0], curpos});
                    }
                }
                curpos++;
            }
        }

        System.out.println("The unsorted data");

        for ( HashMap<String,String> h : keyValuePairs ) {
            for ( String s : h.keySet() ) {
                System.out.print(" " + s + " ");
            }
            System.out.println();
        }
        System.out.println("\n");

        // Sort the data using our custom comparator
        ValueComparator com = new ValueComparator(m);
        List<String> toSort = new LinkedList<String>(m.keySet());
        Collections.sort(toSort, com);

        System.out.println("The sorted data");

        for ( HashMap<String,String> h : keyValuePairs) {

            for ( String s : toSort ) {
                if ( h.containsKey(s) ) {
                    System.out.print(s + " ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

}