public static void main(String[] args) {
    Map<Integer, Person> persons = new TreeMap<Integer, Person>();
    persons.put(433, new Person(433, "John", "Smith");
    persons.put(211, new Person(211, "Peter", "Johnson");
    persons.put(556, new Person(556, "Laura", "Walters");

    // This loop will print out ordering by id
    for (Integer key: persons.keySet())
        System.out.println(persons.get(key));
}