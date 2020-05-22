@Override
public int compareTo(Student other) {
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
  return Comparator.comparing((Student student) -> LocalDate.parse(student.getStudentDOJ(), formatter)).reversed()
      .compare(this, other);
}