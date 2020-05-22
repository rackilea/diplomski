import java.util.*;

public class Ordered2
{
public static void main(String[] args)
{
    String firstString, secondString, thirdString;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Enter three different strings.");
    System.out.println("The string in the middle order lexicographically will be displayed.");
    firstString = keyboard.nextLine();
    secondString = keyboard.nextLine();
    thirdString = keyboard.nextLine();

    String[] array = new String[] {firstString, secondString, thirdString};

    Arrays.sort(array);

    System.out.println("The second string in lexicographic order: " + array[1]);
}
}