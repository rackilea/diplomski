public void add(String last, String first, Integer id, String club) {
    TreeSet<Student> set = new TreeSet<Student>(studentComp);
    if (!map.containsKey(club)) {
        set.add(new Student(last, first, id));
        map.put(club, set);
    } else {
        set = map.get(club);
        set.add(new Student(last, first, id));
    }
}