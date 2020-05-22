Map<Integer,Integer> histogram = new HashMap<Integer, Integer>();
for (Integer x : list) {
    Integer value = histogram.get(x);
    if (value == null) histogram.put(x,1);
    else histogram.put(x, value + 1);
}