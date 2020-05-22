final List<List<PersonObject>> seats = new ArrayList<List<PersonObject>>();
//set a person
List<PersonObject> list = seats.get(a);
if(list == null) {
  list = new ArrayList<PersonObject>();
  seats.add(a, list);
}
list.add(b, myPerson);
//get a person
final PersonObject myPerson = seats.get(a).get(b);