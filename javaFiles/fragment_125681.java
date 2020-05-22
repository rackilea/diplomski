public class StudentSummary {

    @JsonIgnoreProperties(value = { "students" })
    public StudentList studentList = new StudentList();

    public StudentSummary(){
        studentList = new StudentList();
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public void setStudentList(StudentList studentList) {
        this.studentList = studentList;
    }

    //getters setters
}