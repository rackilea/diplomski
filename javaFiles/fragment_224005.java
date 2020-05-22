final Map<Integer,String[]> map = new HashMap<Integer,String[]>();
map.put(1, new String[]{"test1", "stackoverflow"});
map.put(2, new String[]{"test2", "wow"});
map.put(3, new String[]{"new"});

final CombinationsIterator iterator = new CombinationsIterator(map);
while (iterator.hasNext()) {
    System.out.println(
        org.apache.commons.lang3.ArrayUtils.toString(iterator.next())
    );
}