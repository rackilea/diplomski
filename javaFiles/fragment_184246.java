$ cat YourMap.java
public class YourMap extends HashMap<String, List<Integer>> {
    public void put(String key, Integer number) {
        List<Integer> current = get(key);
        if (current == null) {
            current = new ArrayList<Integer>();
            super.put(key, current);
        }
        current.add(number);
    }

    public static void main(String args[]) {
        YourMap m = new YourMap();
        m.put("a", 1);
        m.put("a", 2);
        m.put("b", 3);
        for(Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}

$ java map
b -> [3]
a -> [1, 2]