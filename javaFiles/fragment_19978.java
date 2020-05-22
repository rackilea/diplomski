Map<String, List<Person>> namesMap = new HashMap<String, List<Person>>();

for (Person p : people) {

  List<Person> res = namesMap.get(p.getFirstName());

  // if there is not valid list of names for key add new person
  if (res == null) {
    List<Person> newListOfPeople = new ArrayList<Person>();
    newListOfPeople.add(p);
    namesMap.put(p.getFirstName(), newListOfPeople);
  } else {

    if (p.getLastName() != null) {
      res.add(p);
      namesMap.put(p.getFirstName(), res);
      Iterator<Person> iter = res.iterator();
      // remove null from list if it exists
      while (iter.hasNext()) {
        Person person = iter.next();
        if (person.getLastName() == null)
          iter.remove();
      }
    }
  }
}

for (Map.Entry<String, List<Person>> kv : namesMap.entrySet()) {
  if (kv.getValue() != null) {
    for (Person p : kv.getValue())
      System.out.println(p.getFirstName() + " " + p.getLastName());

  }
}