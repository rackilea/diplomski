import java.util.Scanner;

public class Compute
{

public static void main(String[] args)
{
    Scanner scan = new Scanner("C:/path to file");
    int biggest = 0, num1 = 0, num2 = 0, current1, current2;
    while(scan.hasNextInt())
    {
        current1 = scan.nextInt();
        current2 = scan.nextInt();
        if((Math.abs(current1-current2)) > biggest)   //current1 - current2?  or current2 - current1?  You decide
        {
            biggest = Math.abs(current1-current2);  //if you change that also change this
            num1 = current1;
            num2 = current2;
        }
    }

    System.out.println("The pair with the biggest difference is: "+num1+" and "+num2+". Their difference is: "+biggest);
    scan.close();
}

}