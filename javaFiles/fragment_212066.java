class Student implements Comparable<Student> {

    String id;
    String firstName;
    String lastName;
    Map<String, Course> courses = new HashMap<>();

    Student(String id, String fName, String lName) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getName() {
        return lastName;
    }

    public void setName(String lName) {
        this.lastName = lName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Student other) {
        return this.getId().compareTo(other.getId());
    }

    public void addCourse(Course course) {
        courses.put(course.getId(), course);
    }

    public Map<String, Course> getCourses() {
        return courses;
    }
}