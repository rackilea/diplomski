import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int number1=scanner.nextInt();
        int number2=scanner.nextInt();
        System.out.printf("%d + %d = %d\n", number1, number2, number1+number2);
    }
}