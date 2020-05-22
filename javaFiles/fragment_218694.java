public class Enrolment {
    ...
    @JsonUnwrapped
    public Student getStudent() {
        return student;
    }
    ...
}