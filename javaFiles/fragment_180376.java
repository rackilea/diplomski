Comparator<Person> comparator = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getOldestBirthday().compareTo(p2.getOldestBirthday());
    }
};