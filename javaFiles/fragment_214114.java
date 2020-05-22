import java.util.Scanner;

    public class Main {
public static double test(Scanner scanner)
{
    System.out.println("Enter a number ");

    double n2 = scanner.nextDouble();
    if (n2 %1 != 0) {
        System.out.println("Number is invalid");

    } else {
        System.out.println("You put the number " + n2);
    }
    return n2;
}

public static double test2(Scanner scanner)
{
    System.out.println("Enter a number ");
    double n1 = scanner.nextInt();
    if (n1 %1 != 0) {
        System.out.println("Number is invalid");

    } else {
        System.out.println("You put the number " + n1);
    }
    return n1;
}

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    double sum = test(scanner);
    double sum2 = test2(scanner);
    System.out.println("You put the number " + sum+ "and"+ sum2);

}
}