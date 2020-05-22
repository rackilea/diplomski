import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String> {

    private Map<String, Integer[]> base;

    public ValueComparator(Map<String, Integer[]> m) {
        this.base = m;
    }

    public int compare(String so1, String so2) {

        // get the max and min indices from each data peice
        Integer[] o1 = base.get(so1);
        Integer[] o2 = base.get(so2);

        // compare their min index first
        if (o1[0] < o2[0]) {
            return -1;
        }
        if (o1[0] == o2[0]) { //if they are the same
            if ( o1[1] < o2[1]) { // then look at the max index
                return -1;
            }
            else {
                return 1;
            }                   
        }
        else { 
            return 1;
        }
    }
}