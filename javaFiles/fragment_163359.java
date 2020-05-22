package grading.on.a.loop.java;

import java.util.Scanner;

public class GradingOnALoopJava
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String[] grades = new String[5];

        for(int counter = 0; counter < 5; counter++)
        {
            System.out.println(counter * 5 + 75);
            System.out.print("Please enter your Grade: ");
            grades[counter] = in.nextLine();
            System.out.println("");
        }
    }
}