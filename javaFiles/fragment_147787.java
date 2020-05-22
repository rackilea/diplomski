public class MyClass extends MyBase {
    @Override public <T> Student assign(T object) {
        Student student = new Student();
        if (object instanceof Teacher) {
            Teacher teacher = (Teacher) object;
            student.setTeacherName(teacher.getName());
        } else {
            student.setTeacherName("unknown");
        }
        return student;
    }
}