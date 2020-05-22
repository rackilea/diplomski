Collections.sort(unsortedList,new Comparator<Person>() {
    @Override
    public int compare(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
});