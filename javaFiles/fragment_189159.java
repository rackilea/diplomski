Map<Integer, String> sample() {
    Map map = new HashMap();
    List<String> list = new ArrayList<String>(0);

    for ( int i = 0; i < 50; i++)
        list.add(i + "");

    List<String> sublist = list.subList(0, 10);
    Integer totalsize = list.size();

    map.put("sublist", sublist);
    map.put("original_list_length", totalsize);

    return map;
}