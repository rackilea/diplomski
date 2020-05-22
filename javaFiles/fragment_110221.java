import java.util.Scanner;

public class NewClass {

public static void main(String[] args) 
{

int[] numArr = new int[3];
int sum=0,x;
Scanner keyboard = new Scanner(System.in);



  for(int i=0; i<numArr.length; i++)
 {
        //check if between 1 and 10
     System.out.println("Enter a number in the range 1 to 10: ");

                //check if integer      
    while (!keyboard.hasNextInt())
    {
        System.out.println("Invalid entry, please try again ");
        keyboard.next();
    }
            x = keyboard.nextInt();
           if(x>0 && x<=10)
             numArr[i]=x;
           else{
               System.out.println("Retry Enter a number in the range 1 to 10:");
               i--;
           }

}


     for (int counter=0; counter<numArr.length; counter++)
    {
        sum+=numArr[counter];
    }
    System.out.println("The sum of these numbers is "+sum);
 }

}