List<Person> list = new LinkedList<>(Arrays.asList(new Person("Jack", 3), new Person("Mike", 9)));

System.out.println("before: " + list);

Collections.sort(list, new Comparator<Person>() {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.score - o1.score;
    }
});

System.out.println("after: " + list);