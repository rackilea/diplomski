List<Person> personListConstructor(Object... data) {
    List<Person> personList = new ArrayList<>();
    for (int i = 0; i < data.length / 2; i++) {
        personList.add(new Person((String) data[2 * i], (Integer) data[2 * i + 1]));
    }
    return personList;
}