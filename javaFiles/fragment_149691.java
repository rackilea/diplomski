public class Hw7Pr2 {
    public static void main(String[] args) {
        int[] grades = { 40, 55, 70, 58 };

        int best = best(grades);
        System.out.println("The best scores is: " + best);

        // Print Grade
        System.out.println("Grade: ");

        for (int i = 1; i <= grades.length; i++) {
            char grade = gradeLetter(grades[i-1], grades);
            String output = " ";
            output += "Student " + i + " score is " + grades[i-1] + " and grade is " + grade + "\n";
            System.out.println(output);
        }

    }

    private static char gradeLetter(int grade, int[] grades) {
        char charGrade = 0;
            if (grade >= best(grades) - 10)

                charGrade = 'A';

            else if (grade >= best(grades) - 20)

                charGrade = 'B';

            else if (grade >= best(grades) - 30)

                charGrade = 'C';

            else if (grade >= best(grades) - 40)

                charGrade = 'D';

            else

                charGrade = 'F';


        return charGrade;
    }

    public static int best(int[] grades) {

        int best = grades[0];
        for (int i = 1; i < grades.length; i++) { //will save a compare operation
            if (grades[i] > best)
                best = grades[i];
        }
        return best;
    }
}