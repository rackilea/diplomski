import java.util.Scanner;

public class Looper {

  public static void main(String[] args) {
    int highest = 100;
    int lowest = 0;
    int grade = 0;
    int students = 0;
    float total = 0;
    double average = 0;

    Scanner input = new Scanner(System.in);

    System.out.println("Enter number of students: ");
    students = input.nextInt();

    if (students <= 10) {
      System.out.println("Enter the grades of the students: ");



      // ADDED CODE
      for(int i = 0; i < students; i++) {
        do {
          grade = input.nextInt();

          if(grade >= 0 && grade <= 100) {
            System.out.println("Grade must be between 0 and 100");
          }
        } while(grade < 0 || grade > 100);

        if(grade > highest) {
          highest = grade;
        }
        if(grade < lowest) {
          lowest = grade;
        }

        total += grade;
      }

      average = (total/students);

      System.out.println("The highest is " + highest);
      System.out.println("The lowest is " + lowest);
      System.out.println("The average is " + average);
      // END ADDED CODE


    } else if (students >= 11) {
      System.out.println("Too many Students");
    }
  }
}