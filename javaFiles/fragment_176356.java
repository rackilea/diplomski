import java.util.Scanner;

public class exampleWork {
    public static void main(String[] args) {
        //create a scanner
        Scanner input = new Scanner(System.in);

        //create a variable to hold the positive integers
        int pos = 0;

        //create a variable to hold the negative integers
        int neg = 0;

        //create a variable to hold the total number of entries
        int total = 0;

        while(true) {
            System.out.println("Enter an integer, the input ends if it is 0: ");
            usrInput = input.nextInt();
            if(usrInput==0)
                break;

            if (usrInput > 0)
                pos++;
            else
                neg++;

            total += usrInput;
        }

        int count=pos+neg;
        if (count > 0){
            System.out.println("The number of positives is " + pos);
            System.out.println("The number of negatives is " + neg);
            System.out.println("The total is " + total);
            System.out.println("The average is " + ((float)total / count)); //Not sure if this typecast is correct, it's been a long time since i have worked in java
        }
    }
}