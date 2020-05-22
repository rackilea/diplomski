List<Person> personListConstructor(String... data) {
    List<Person> personList = new ArrayList<>();
    for (int i = 0; i < data.length / 2; i++) {
        personList.add(new Person(data[2 * i], Integer.parseInt(data[2 * i + 1])));
    }
    return personList;
}