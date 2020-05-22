public static void main(String[] args) throws Exception {
    Map<Integer, Integer> mapofstuff = new TreeMap<>();
    BufferedReader in = new BufferedReader(new FileReader("C:\Users\Luis\Desktop\Java.POO\testingide\src\la2\grades.txt"));
    String line = "";
    while ((line = in.readLine()) != null) {
        String parts[] = line.split(" ", 2);

        int part0 = Integer.parseInt(parts[0].trim());
        int part1 = Integer.parseInt(parts[1].trim());

        if(mapofstuff.containsKey(part0)) {
            mapofstuff.put(part0, mapofstuff.get(part0) + part1);
        }

        else {
            mapofstuff.put(part0, part1);
        }
    }
    in.close();


    System.out.println(entriesSortedByValues(mapofstuff));
}


public static <K,V extends Comparable<? super V>>
SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = -e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : -((Integer)e1.getKey()).compareTo((Integer)e2.getKey());
                }
            }
    );
    sortedEntries.addAll(map.entrySet());
    return sortedEntries;
}