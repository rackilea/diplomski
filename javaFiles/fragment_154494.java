@Column(name = "students")
public Long getStudentsInternal() {
    return students;
}

@Transient
public Long getStudents() {
    if (students == null) {
        return 0l;
    }
    return students;
}