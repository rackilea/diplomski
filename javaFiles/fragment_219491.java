import java.util.Scanner;

class classSystem {
    static Scanner input; //created a static reference for Scanner
                          //as you will be using in both the methods

    public static void main(String[] args) {
        input = new Scanner(System.in);   //creating the Scanner object.
        System.out.println("Weclome instructure to your Class System!");
        System.out.println("Follow each steps to turn in your work instructor.");
        System.out.println("\n1.) Enroll Students:");

        System.out.print("\nHow many students are enrolled? ");
        int studentAmount = input.nextInt();
        input.nextLine();     //added this to consume new-line leftover

        String[] enrolledStudents = getStudentAttendance(studentAmount);

        System.out.println("Here is your attendance list:");

        for (int count = 0; count < enrolledStudents.length; count++) {
            System.out.print("\n\t" + (count + 1) + ".) " + enrolledStudents[count]);
        }

        System.out.print("\n\nWhat sudent do you want to search: ");

        String studentSearch = input.nextLine();   

        System.out.println(getStudent(enrolledStudents, studentSearch));
        input.close();   //close the scanner 
    }

    public static String[] getStudentAttendance(int studentAmount) {

        String[] enrolledStudents = new String[studentAmount];

        System.out.println("Input the students names:");
        for (int count = 0; count < enrolledStudents.length; count++) {
            System.out.print((count + 1) + ".) ");
            enrolledStudents[count] = input.nextLine();
        }

        return enrolledStudents;
    }

    public static String getStudent(String[] enrolledStudents, String studentSearch) {
        boolean flag = false;   //added flag, this will be true if name is found 
                                //otherwise false
        for (int count = 0; count < enrolledStudents.length; count++) {
            if (studentSearch.equals(enrolledStudents[count])) {
                flag = true;
                break;          //if name is found breaking the loop.
            } else {
                flag = false;
            }
        }
        if (flag == true)     //checking the flag here
            return studentSearch + " is present in the class";
        else
            return studentSearch + " is not present in the class: ";
    }

}