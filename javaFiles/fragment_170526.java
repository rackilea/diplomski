final Map<Integer, Map<Integer, PersonObject>> seats = new HashMap<Integer, Map<Integer, PersonObject>>(){
  @Override
  public  Map<Integer, PersonObject> get(Object key) {
     Map<Integer, PersonObject> map = super.get(key);
     if(map == null) {
        map = new HashMap<Integer, PersonObject>();
        put((Integer)key, map);
     }
     return map;
  }
};
//set a person    
map.seats.get(a).put(b, myPerson);
//get a person
myPerson.get(a).get(b);