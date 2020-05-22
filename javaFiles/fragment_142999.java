import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
class Eggonlegs {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
        map.put(14152,"First");
        map.put(14153,"Second");
        map.put(14159,"Third");

        List<Integer> list = new ArrayList<Integer>(map.keySet());

        for(int i = 0; i < list.size(); i++) {
            if(i == 0) System.out.println(0);
            else System.out.println(list.get(i) - list.get(i-1));
        }
    }
}