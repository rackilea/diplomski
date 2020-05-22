private static void displayReportByMarks() {
     List<Student> studentsByMarks = students.stream().sorted(
             (s1, s2) -> //just do the comparison for sorting here
             )).collect(Collectors.toList());
     for (Student : students) {
          // assuming you have a Student.toString() method implemeted.
          System.out.println(student);
     }
}