public class StudentTClass {

    //@EmbeddedId
    private StudentTClassPK pk = new StudentTClassPK();

    @EmbeddedId
    public StudentTClassPK getPk() {
        return pk;
    }