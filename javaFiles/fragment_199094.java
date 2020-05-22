import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main
{
public static void main(String args[])
{
    Random rand = new Random();
    ArrayList<Integer> array = new ArrayList<Integer>();
    int x ;
    int sum = 0;
    System.out.print("Input a number: ");
    Scanner input = new Scanner(System.in);
    int mean;
    int temp = input.nextInt();

    for(int i = 0;i < 10000;i++)
    {
        x = Math.abs(rand.nextInt()%temp)+1;
        System.out.println(x);
        array.add(x); //add random number to array
        sum += x; //compute sum ro calculate mean later;
    }

    int min = array.get(0);
    int max = array.get(0);


    //find min

    for(int i = 0; i < array.size();i++)
    {
        if(array.get(i) < min)
        {
            min = array.get(i);
        }
    }

    //find max

    for(int i = 0; i < array.size();i++)
    {
        if(array.get(i) > max)
        {
            max = array.get(i);
        }
    }

    //find mean
    mean = sum/array.size();

    //result
    System.out.println("Min is : "+min);
    System.out.println("Max is : "+max);
    System.out.println("Sum is : "+sum);
    System.out.println("Mean is : "+mean);
}
}