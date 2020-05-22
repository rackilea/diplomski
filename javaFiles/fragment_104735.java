public class MyComparator implements Comparator<Entry<String, String>> {
    @Override
    public int compare(Entry<String, String> left, Entry<String, String> right) {
        int valueComp = left.getValue().compareTo(right.getValue());
        if (valueComp != 0)
            return valueComp;
        int keyComp = left.getKey().compareTo(right.getKey());
        return keyComp;
    }
}

@Test
public void testSorting() throws Exception {
    Map<String, String> tree = new TreeMap<String, String>();
    tree.put("D", "A");
    tree.put("A", "A");
    tree.put("F", "C");
    tree.put("E", "B");
    tree.put("C", "A");
    tree.put("B", "B");
    Set<Entry<String, String>> entrySet = tree.entrySet();
    Comparator<? super Entry<String, String>> comparator = new MyComparator();
    TreeSet<Entry<String, String>> sorted = new TreeSet<Entry<String, String>>(comparator);
    sorted.addAll(entrySet);
    for (Entry<String, String> entry : sorted) {
        System.out.println(entry);
    }
}