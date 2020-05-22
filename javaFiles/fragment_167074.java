package array1;

import java.io.IOException;
import java.util.Scanner;

public class Mainclass {
    public static void main(String args[]) throws NumberFormatException, IOException
    {
        int a,k=0,line=0,count=0;
        while(true)
        {
        System.out.println("Round" + " " + ++k + ":");
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter the search range:");
            a= scn.nextInt();
            {
                if (a< 0)
                {
                    System.out.println("End");
                System.exit(0);
                }
            }
            System.out.println("The Twin Prime Numbers within the given range are : ");
            for(int i=2; i<=(a-2); i++)
            {
                if(isPrime(i) == true && isPrime(i+2) == true)
                {
                    System.out.print("("+i+","+(i+2)+") ");
                    line++;
                    if(line==2)
                    {
                        System.out.println();
                        line=0;
                    }
                    count++;

                }

            }
            System.out.println();
            System.out.println("the number of twin prime numbers less than or equal to"+a+"is"+count);
        }
    }

     static boolean isPrime(int n) //funton for checking prime
     {
         int count=0;
         for(int i=1; i<=n; i++)
             {
                 if(n%i == 0)
                     count++;
             }
         if(count == 2)
             return true;
          else
             return false;
     }
}