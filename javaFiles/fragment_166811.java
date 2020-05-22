public static List<String> orderStudent(List<Student> ls) {
    Collections.sort(ls, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.getScore().compareTo(o1.getScore());
        }
    });
    List<String> result = new ArrayList<String>();
    for(Student s : ls) {
        result.add(s.getName());
    }
    return result;
}