import java.io.*;
import java.util.*;

public class Tester1
{
    public static void main(String args[]) {
        Scanner kbReader= new Scanner (System.in);

        int scores[] = new int [10];

        int counter = 0;
        int sum = 0;    
        int input = 0;

        do {
            System.out.println("Enter score out of 10 or negative to break.");
            input=kbReader.nextInt();

            if (input<0) {
                break;
            } else if (input>10) {
                System.out.println("Score must be out of 10");
            } else {
                scores[input]++;
                counter++;
                sum+=input;
            }
        } while (input>0);

        System.out.println("Score\t# of occur...");
        for(int i =0; i<10; i++) {
            System.out.println(i + "\t" + scores[i]);
        };

        System.out.println("The mean score is " +(sum/counter));
    }
}