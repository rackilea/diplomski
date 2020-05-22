Person p = structure.search(
    new Matcher<Person,Integer>() {
        public boolean matches(Person person, Integer id) {
            return person.getID() == id;
        }
    ),
    12
);