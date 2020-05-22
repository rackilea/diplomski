import java.util.Arrays;
public class Assignment2 {

    static String[] students;
    static double[][]  grades;

    public static void main(String[] args) {
        initializeData();
        displayData();
    }

    /**
     * Method that initializes 5 students and grades for 5 courses and populates data.
     */
    public static void initializeData() {
        //create arry with student names
        students = new String[] {"James", "Luke", "Alex", "Jenny"};

        //create 2d array and populate it
        grades = new double[][] {{98, 72, 85, 77, 90},{25,49,26,77,60},{13,8,46,52,28},{77,81,85,69,88}};
    }

    /**
     * Method that takes the data from initializeData() and displays it to the screen.
     */
    public static void displayData() {
        System.out.println(Arrays.toString(students));
    }
}