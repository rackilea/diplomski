protected void findPhone(String lname) {
    if (person.containsKey(lname)) {
        List<Integer> listPhone = person.get(lname).stream()
                .map(Person::getPhone)
                .collect(toList());
    }
}