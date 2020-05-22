public class TestClass {    
    private Classroom c;

    public TestClass() {
        c = new Classroom();
        private Student s = new Student();
        s.setName("John");
        c.add(s);
    }

    public static void main(String[] args)
    {
        new TestClass();
    }
}

public Classroom {
    private List<Student> studentList;

    public Classroom() {
         studentList = new ArrayList<Student>();
    }

    public boolean add(Student newStudent) {
         studentList.add(newStudent);
         return true; //not sure why you're returning booleans
    }
}