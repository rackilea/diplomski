@Column(name = "students")
private Long students;

public Long getStudents() {
    if (students == null) {
        return 0l;
    }
    return students;
}