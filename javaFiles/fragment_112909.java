for(House h: houses){
    List<House> l = map.get(h.rooms);
    if(l==null){ 
        l = new ArrayList<House>();
        map.put(h.rooms, l);
    }
    l.add(h);
}