public ArrayList<Student> getStudentsByMajor(String major)
{
    ArrayList<Student> students = new ArrayList<>();

    for (Student student : studentList) {
        if (student.getMajor().equals(major))
            students.add(student);
    }

    return students;
}