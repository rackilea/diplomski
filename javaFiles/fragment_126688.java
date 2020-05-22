public class Student {

    String StuID;
    String FName;
    String LName;
    String Email;
    int Age;
    private int[] Grades = new int[3];

    public Student(String stuid, String fname, String lname, String email, int age, int[] grades) {
        this.StuID = stuid;
        this.FName = fname;
        this.LName = lname;
        this.Email = email;
        this.Grades = grades;
    }

    public int[] getGrades() {
        return Grades;
    }

    public void setGrades(int[] grades) {
        Grades = grades;
    }

    public String toString() {
        return String.format("StuID: %s\t First Name: %s\t Last Name: %s\t E-Mail: %s\t Age: %s\t Grades: %s\t", this.StuID, this.FName, this.LName, this.Email, this.Age, this.Grades);
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String fName) {
        FName = fName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getStuID() {
        return StuID;
    }

    public void setStuID(String stuID) {
        StuID = stuID;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String lName) {
        LName = lName;
    }
}