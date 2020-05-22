import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class GfG {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 3);
        map.put(5, 3);
        map.put(3, 1);
        map.put(6, 3);
        Set<Entry<Integer, Integer>> entry = map.entrySet();
        for(Entry<Integer, Integer> e: entry){
            int key = e.getKey();
            int value = e.getValue();
            if(map.containsKey(value) && map.get(value) != null && map.get(value) == key){
                System.out.println(key +" -> "+value);
            }
        }
    }
}