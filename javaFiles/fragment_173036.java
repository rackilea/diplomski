public class Student {
    private final int id;
    private final String subjectId;
    private final int grade;

    public Student(int id, String subjectId, int grade) {
        super();
        this.id = id;
        this.subjectId = subjectId;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getGrade() {
        return grade;
    }

}