@Entity
public class Bridge extends Model {

    Bridge() {
        bridgeId = new BridgeId();      
    }

    @EmbeddedId
    protected BridgeId bridgeId;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne 
    @JoinColumn(name="course_id", insertable = false, updatable = false)
    private Course course;

    public String additional_field;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student aStudent) {
        student=aStudent;
        bridgeId.student_id = aStudent.id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course aCourse){
        course=aCourse;
        bridgeId.course_id = aCourse.id;
    }
}