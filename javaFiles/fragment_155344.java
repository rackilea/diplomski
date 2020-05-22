package Examples;

public class MarksQuiz {
    public static void main(String[] args) {
        // create variables to be used inside the "for" loops as counters
        int i;
        int row;
        int column;
        String[] students = { "Peter", "Lydia", "Kate", "Steve", "Alexa" };
        // Create a 2-D array of the int type to stores scores
        int[][] scores = { { 82, 90 }, { 78, 90 }, { 84, 80 }, { 85, 73 }, { 81, 93 } };

        // Display headings for information to be spaced equally
        System.out.printf("%-7s%-7s%-7s%-7s%-7s", "Name", "Test1", "Test2", "Sum of tests ", "Average grade\n");
        System.out.print("----------------------------------------\n");

        //Removed the For loop from Here
        /*for (i = 0; i < students.length; i++) {
            System.out.print(students[i] + " \n");
        }*/

        // cycle through the each group (outside part of the array)
        for (row = 0; row < scores.length; row++) {

                System.out.print(students[row]);//Inserted the Print Statement to Fix your Issue
                    // create variables to store computations and set initial value to
            // zero
            int sum = 0;
            double avg = 0;
            // System.out.print(students[i]);

            // cycle through each set of elements of each group (inside part of
            // array)
            for (column = 0; column < scores[row].length; column++) {

                // for each set of elements -- add all elements in each group
                // (int sum must be set to 0 each time)
                sum += scores[row][column];

                // calculate average by dividing the value in int sum by the
                // number of elements in the group (group size)
                avg = sum / scores[column].length;

                // display the values of each row
                System.out.print(scores[row][column] + "      ");

            }

            // display the sum of each group (row) with an identifying message
            System.out.print(sum + "           ");

            // display the average of each group (row) with an identifying
            // message
            System.out.print(avg);

            // System.out.print(" -------------------------\n");
            // create new line after each computation
            System.out.println();

            // Create dotted lines to separate each set of values displayed
            System.out.print("----------------------------------------\n");

        }
    }
}