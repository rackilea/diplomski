Person person = new Person();
ListIterator<Person> listIterator = L.listIterator();

while (listIterator.hasNext()) {
      person = listIterator.next();
      double value = person.getDoubleAttribute();
}