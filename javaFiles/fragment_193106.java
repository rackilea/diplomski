class Student {
    private String givenName;
    private String surname;
    private String module;

    public Student(String givenName, String surname, Course module) {
        this.givenName = givenName;
        this.surname = surname;
        this.module = module.name;
    }
}

public enum Course {
    AI("Course 1"),
    BWL("Course 2"),
    VWL("Course 3"),
    MA("Course 4");

    private final String name;

    private Course(String name) {
        this.name = name;
    }
}

public void test(String[] args) {
    Student student = new Student("Given name", "surname", AI);
}