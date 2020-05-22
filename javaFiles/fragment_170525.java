final Map<Integer, Map<Integer, PersonObject>> seats = new HashMap<Integer, Map<Integer, PersonObject>>();
//set a person
Map<Integer, PersonObject> map = seats.get(a);
if(map == null) {
  map = new HashMap<Integer, PersonObject>();
  seats.put(a, map);
}
map.put(b, myPerson);
//get a person
myPerson.get(a).get(b);