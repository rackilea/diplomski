public class ClassRoom 
{
    private final Map<String, Student> students = new HashMap<String, Student>();

    public void add(final Student s) { this.students.put(s.getName(), s); }

    public Student getStudentByName(final String n) { return this.students.get(n); }    
}