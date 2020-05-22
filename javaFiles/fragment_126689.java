import java.util.ArrayList;

public class Roster {
    ArrayList<Student> studentArray;

    public Roster(ArrayList<Student> ar) {
        studentArray = ar;
    }

    // 3.C - Print Average Grade
    public void print_average_grade(String studentID) {
        for (Student v : studentArray) {
            if (v.getStuID().equals(studentID)) {
                double total = v.getGrades()[0] + v.getGrades()[1] + v.getGrades()[2];
                double average = total / 3;
                System.out.println("Student ID#" + studentID + " Grade AVG= " + average);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> studentArray = new ArrayList<Student>();

        int[] grades1 = {88, 79, 59};
        int[] grades2 = {91, 72, 85};
        int[] grades3 = {85, 84, 87};
        int[] grades4 = {91, 98, 82};
        int[] grades5 = {99, 98, 97};

        studentArray.add(new Student("1", "John", "Smith", "John1989@gmail.com", 20, grades1));
        studentArray.add(new Student("2", "Susan", "Erickson", "Erickson_1990@gmailcom", 19, grades2));
        studentArray.add(new Student("3", "Jack", "Napoli", "The_lawyer99yahoo.com", 19, grades3));
        studentArray.add(new Student("4", "Erin", "Black", "Erin.black@comcast.net", 22, grades4));
        studentArray.add(new Student("5", "Captain", "Planet", "PowIsYours@planet.edu", 65, grades5));

        Roster r = new Roster(studentArray);
        for (Student v : studentArray) {
            r.print_average_grade(v.getStuID());
        }
    }
}