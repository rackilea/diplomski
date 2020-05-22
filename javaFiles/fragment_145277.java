final NavigableMap<String,Integer> map = 
        new TreeMap<String, Integer>(new Comparator<String>() {
    public int compare(final String o1, final String o2) {
        int result;
        if("Not-Specified".equals(o1)) {
            result=1;
        } else if("Not-Specified".equals(o2)) {
            result=-1;
        } else {
            result =o1.compareTo(o2);
        }
        return result;
    }

});
map.put("test", Integer.valueOf(2));
map.put("Not-Specified", Integer.valueOf(1));
map.put("testtest", Integer.valueOf(3));
final Entry<String, Integer> lastEntry = map.lastEntry();
System.out.println("Last key: "+lastEntry.getKey()
         + ", last value: "+lastEntry.getValue());