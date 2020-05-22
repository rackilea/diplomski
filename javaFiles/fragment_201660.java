Collections.sort(unsortedList,new Comparator<Person>() {
    @Override
    public int compare(Person a, Person b) {
        return b.getName().compareTo(a.getName());
    }
});