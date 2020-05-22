public class Student extends Person {
    @Basic
    @NotNull
    @Column(name = "studentId")
    private String studentIdentifier;
}