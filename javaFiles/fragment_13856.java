package com.general.generics;
    import java.util.Scanner; 
    public class GPA

    {
      public static void main(String[] args)

   {

    Scanner kbReader = new Scanner(System.in);

    System.out.println("Enter number of classes: ");
    int numberClasses = kbReader.nextInt();

    int i;
    int totalCreditForGPA=0; //these should be defined outside loop and should be double for precision.
    int totalCreditHours=0;
      for (i = 0; i < numberClasses; i++)
      {

      System.out.print("Enter letter grade of class: ");
          int letterGrade = kbReader.nextInt();

      System.out.print("Enter credit hour of class: ");
      int creditHour = kbReader.nextInt();



    switch (letterGrade)
        {
       case 'A':
       case 'a': totalCreditForGPA = (int) (totalCreditForGPA + (creditHour * 4.0)); //result should be type to int or use totalCreditForGPA as double
             totalCreditHours =  totalCreditHours + creditHour;
             break;
      case 'B':
      case 'b':  totalCreditForGPA = (int) (totalCreditForGPA + (creditHour * 3.0));
             totalCreditHours =  totalCreditHours + creditHour;
             break;
      case 'C':
      case 'c':  totalCreditForGPA = (int) (totalCreditForGPA + (creditHour * 2.0));
             totalCreditHours =  totalCreditHours + creditHour;
             break;
      case 'D':
      case 'd':  totalCreditForGPA = (int) (totalCreditForGPA + (creditHour * 1.0));
             totalCreditHours =  totalCreditHours + creditHour;
             break;
      case 'F':
      case 'f':  totalCreditForGPA = (int) (totalCreditForGPA + (creditHour * 0.0));
             totalCreditHours =  totalCreditHours + creditHour;
             break;
      default:
             System.out.println("Invalid letter grade.");
        }
      }

    int GPA = totalCreditForGPA;
    System.out.println("Your GPA is " + GPA);
       }
    }