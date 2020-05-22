@OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
private List<Student> schoolStudents = new ArrayList<Student>();

public int getStudentsCount() {
    return schoolStudents.size();
}