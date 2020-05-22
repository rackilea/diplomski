public class Student implements Comparator<Student>, Comparable<Student> {
    private String name, surname;
    private Integer index;
    private List<PassedExam> passedExamList = new ArrayList<PassedExam>();

    public Student(String name, String surname, int index){
        this.name = name;
        this.surname = surname;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<PassedExam> getPassedExamList() {
        return passedExamList;
    }

    public int getTotalMarks(){
        int total = 0;
        for(PassedExam exam : passedExamList)
            total += exam.getMark();
        return total;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o2.getTotalMarks(), o1.getTotalMarks());
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getTotalMarks(), this.getTotalMarks());
    }
}