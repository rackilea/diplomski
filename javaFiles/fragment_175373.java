import java.util.Scanner;
public class SumOfNumbers {

public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Number?");
    int number = keyboard.nextInt();
    recursion(number);
}
public static void recursion(int number)
{
    if (number>1)
    {
        recursion(number-1);
        System.out.print(number);
    }
    else {
        System.out.print(number);
    }

}

}