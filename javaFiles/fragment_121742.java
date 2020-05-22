public class AssignGrades {

    private int[] y;

    public AssignGrades(int[] num1) {
        y = num1;
    }

    // method to set grades
    void setGrades() {
        for (int i = 0; i < y.length; i++)
        {
            // assign grades

            if (y[i] < 50)
                System.out.println("FAIL" + y[i]);
            else if (y[i] < 60)
                System.out.println("grade is C" + y[i]);
            else if (y[i] < 70)
                System.out.println("grade is B" + y[i]);
            else if (y[i] < 80) {
                System.out.println("grade is A" + y[i]);
            }

        }
    }

    // method to show student grades
    void showGrades() {
        for (int u : y){
            System.out.println(u);
        }
    }

}




import java.util.Scanner;

public class AssignGradesDemo {

    public static void main(String[] args) {
        int t = 0;
        System.out.println("enter no of students");

        Scanner input = new Scanner(System.in);
        t = input.nextInt();

        int[] num1 = new int[t];
        System.out.println("enter grades");

        for (int i = 0; i < num1.length; i++) {
            num1[i] = input.nextInt();
        }
        input.close();

        AssignGrades ag = new AssignGrades(num1);

        ag.setGrades();
        ag.showGrades();
    }

}