Person p1 = new Person("Jenny",20);
Person p2 = new Person("Kate",22);
List<Person> pList = Arrays.asList(p1, p2);

interface Operation {
  abstract void execute(Person p);
}

public void modList(List<Person> list, Operation op) {
  for (Person p : list)
    op.execute(p);
}

modList(pList, new Operation {
  public void execute(Person p) { p.setAge(p.getAge() + 1)};
});