public class UniversityPeople {
    private final Student[] students;
    private final Instructor[] instructors;

    private UniversityPeople(int studentCount, int instructorCount) {
        students = new Student[studentCount];
        instructors = new Instructor[instructorCount];
    }

    public static UniversityPeople forStudents(int size) {
        return new UniversityPeople(size, 0);
    }

    public static UniversityPeople forInstructors(int size) {
        return new UniversityPeople(0, size);
    }
}