public class StudentManager {
    List<Student> list;
    public StudentManager(List<Student> list) {
        this.list = new ArrayList<>(list); // make a defensive copy
    }
    public Student getStudent(int code) {
        for(Student s : list) {
            if(s.getCode() == code) {
                return s;
            }
        }
        return null; // or something to indicate not found
    }
}