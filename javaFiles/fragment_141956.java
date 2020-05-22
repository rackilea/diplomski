private List<Student> students = new ArrayList<>();

private static void addStudent(int id, String firstName, String lastName, 
                               int mathMark1, int mathMark2, int mathMark3, 
                               int englishMark1, int englishMark2,
                               int englishMark3) {
    students.add(new Student(id, firstName, lastName, mathMark1, mathMark2,
                     mathMark3, englishMark1, englishMark2,englishMark3));
}