class Student {
    private String name;
    private int[] studentGrades;

    public Student(String name, int[] studentGrades) {
        this.name = name;
        this.studentGrades = studentGrades;
    }

    public String getName() {
        return name;
    }

    public int[] getStudentGrades() {
        return studentGrades;
    }

    @Override
    public String toString() {
        return "Student{" +
                  "name=" + name + ", " +
                  "studentGrades=" + Arrays.toString(studentGrades) +
                "}";
    }
}