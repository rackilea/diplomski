put(String s, int i){
    List<Integer> list = map.get(s);
    if(list == null){
        list = new ArrayList<Integer>();
        map.put(s, list);
    }
    list.add(i);
}