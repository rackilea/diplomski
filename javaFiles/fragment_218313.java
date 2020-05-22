interface Operation<E> {
  abstract void execute(E elem);
}

public <E> void modList(List<? extends E> list, Operation<E> op) {
  for (E elem : list)
    op.execute(elem);
}

modList(pList, new Operation<Person>() {
    public void execute(Person p) { p.setAge(p.getAge() + 1); }
});