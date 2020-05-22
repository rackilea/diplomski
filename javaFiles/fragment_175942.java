List<Person> persons = ...;
final List<Integer> ids = ...;

Collections.sort(persons, new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        int index1 = ids.indexOf(p1.getId());
        int index2 = ids.indexOf(p2.getId());
        return index1 < index2 ? -1 : (index1 == index2 ? 0 : 1);
    }
});