import java.util.TreeMap;
class Eggonlegs {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
        map.put(14152,"First");
        map.put(14153,"Second");
        map.put(14159,"Third");

        Integer first = null;

        for(Integer i : map.keySet()) {
            if(first == null) first = i; // save the first value
            System.out.println(i - first);
        }
    }
}