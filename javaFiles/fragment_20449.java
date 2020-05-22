public class Student {
    public String strFirstName;
    public String strLastName; 
    public String strMajor;
    public int intGPA;
    public int intUIN;
    public String strNetID;
    public String strAge;
    public String strGender;

    public static void Student(String strFirstName, String strLastName, String strMajor, int intGPA, int intUIN, String strNetID, String strAge, String strGender) {
        this.strFirstName = strFirstName;
        this.strLastName = strLastName;
        this.strMajor = strMajor;
        this.intGPA = intGPA;
        this.intUIN = intUIN;
        this.strNetID = strNetID;
        this.strAge = strAge;
        this.strGender = strGender;
    }
}