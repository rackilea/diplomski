public static void findOldestPerson(List<Person> persons) {
    Person oldest = null;
    for (Person p : persons) {
        if (oldest == null || p.getAge() > oldest.getAge()) oldest = p;
    }
    // Do something with the oldest person.
}