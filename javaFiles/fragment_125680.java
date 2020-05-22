public class StudentList {

    int numberOfStudents;
    int totalExpenditures;
    List<Student> students = new ArrayList<>();

    public StudentList(){
        for(int i =0; i<10; i++){
            students.add(new Student());
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getTotalExpenditures() {
        return totalExpenditures;
    }

    public void setTotalExpenditures(int totalExpenditures) {
        this.totalExpenditures = totalExpenditures;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //getters setters
}