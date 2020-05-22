public static void main(String[] args) {
    char[] arr = {'A', 'B', 'E', 'A', 'C', 'D', 'E', 'A', 'C', 'E', 'B', 'A', 'A', 'B','E','E'};
    Map<Character, Integer> map = new HashMap<>();
    for (char c: arr){
        if (!map.containsKey(c)){
            map.put(c, 1);
        }else{
            map.put(c, map.get(c)+1);
        }
    }
    ValueComparator vc = new ValueComparator(map);
    Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>(vc);
    sortedMap.putAll(map);
    System.out.println(sortedMap);
}

public class ValueComparator implements Comparator<Character>   {

    Map<Character, Integer> map;

    public ValueComparator(Map<Character, Integer> map){
        this.map = map;
    }


    @Override
    public int compare(Character a, Character b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys 
    }

}