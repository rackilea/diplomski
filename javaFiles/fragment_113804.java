for (String w : list) {
    Integer i = map.get(w);
    if(i == null) {
        map.put(w, 1);
    }
    else {
        map.put(w, i+1);
    }
}