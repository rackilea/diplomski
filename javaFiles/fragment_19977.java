List<Person> supplementaryList = new ArrayList<Person>();

Map<String, Person> map = new HashMap<String, Person>();

for (Person person : people) {

  Person temp = map.get(person.getFirstName());

  if (temp != null) {
    supplementaryList.add(person);
    if (temp.getLastName() == null)
      map.remove(temp.getFirstName());

  } else {
    map.put(person.getFirstName(), person);
  }
}

for (Map.Entry mapper : map.entrySet()) {
  Person temp = (Person) mapper.getValue();
  System.out.println(temp.getFirstName());
  System.out.println(temp.getLastName());
  System.out.println();
}

for (Person p : supplementaryList) {

  System.out.println(p.getFirstName() + p.getLastName());

}