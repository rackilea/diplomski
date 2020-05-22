class Student
{
    long id;
}

final List<Student> students = /*something*/;
final List<Long> rollNoList = /*something*/;

List<Student> newStudents = students.stream()
                                    .filter(student -> rollNoList.contains(student.id))
                                    .collect(Collectors.toList());