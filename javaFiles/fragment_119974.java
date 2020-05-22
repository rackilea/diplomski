private static Comparator<Student> studentComp = new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return (s1.last.compareTo(s2.last));
    }
};