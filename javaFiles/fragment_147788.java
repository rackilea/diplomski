public class MyClass extends MyBase {
    @Override public <T> Student assign(T object) {
        return new Student();
    }

    public Student assign(Teacher teacher) {
        Student student = new Student();
        student.setTeacherName(teacher.getName());
        return student;
    }
}