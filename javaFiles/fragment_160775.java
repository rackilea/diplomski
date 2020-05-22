import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class SortCount {
    public static void main(String[] args) {
        int nums[] = {0,0,0,1,3,3,2,1,3,5,6,0};
        HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(counts.containsKey(nums[
                Integer c = counts.get(nums[i]) + 1;
                counts.put(nums[i], c);
            }
            else {
                counts.put(nums[i],1);
            }
        }

        ValueComparator<Integer,Integer> bvc = new ValueComparator<Integer,Integer>(counts);
        TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(bvc);
        sortedMap.putAll(counts);

        ArrayList<Integer> output = new ArrayList<Integer>();
        for(Integer i : sortedMap.keySet()) {
            for(int c = 0; c < sortedMap.get(i); c++) {
                output.add(i);
            }
        }

        System.out.println(output.toString());
    }
}