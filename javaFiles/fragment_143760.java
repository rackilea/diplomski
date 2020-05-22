List<Student> students = ...
Collections.sort(students, new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        // compare person
        return 0;
    }
});