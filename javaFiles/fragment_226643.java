import java.util.Scanner;

    public class test
    {
       public static void main(String args[])
       {
          //A Simple Averaging Program

          Scanner input = new Scanner(System.in);

          //Declare variables:

          double total = 0;
          double counter = 0;
          long mark;
          double average;
          int numOfPupils;
          int totalMarks;

          //Ask how many papers the teacher would like to average:

          System.out.println("How many student's papers would you like to avarage?");
          numOfPupils = input.nextInt();

          //Ask how many marks were available to the student to earn:

          System.out.println("How many marks were available to the student?");
          totalMarks = input.nextInt();

          //Repeat the amount of papers times:

          while (counter < numOfPupils)
          {

             //Ask how many marks the student got:

             System.out.printf("\nHow many marks did student number %s get? \nStudent %s scored: ", counter + 1, counter + 1);
             mark = input.nextLong();

             total += mark;
             System.out.printf("Student %s scored: %s%%", counter + 1, ((100 / totalMarks) * mark));
             counter++;
          }
          average = total / (counter);
          System.out.printf("\nThe average was %s marks.", average);

          input.close();

       }
    }