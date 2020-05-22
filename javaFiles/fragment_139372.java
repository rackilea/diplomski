import java.util.Random;
import java.util.Scanner;

public class RandomNumber {

    public static void main(String[] args) {
        long[] numbers = new long[4];
        Scanner input = new Scanner(System.in);
        Random id = new Random(4);
        String[] name = new String[4];

        System.out.print("Enter the numbers: ");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextLong();
        }

        for (int i = 0; i < numbers.length; i++) {
            int randomPosition = id.nextInt(4);
            long temp = numbers[i];
            numbers[i] = numbers[randomPosition];
            numbers[randomPosition] = temp;
        }

        System.out.println("Enter the names: ");

        for (int i = 0; i < name.length; i++) {
            name[i] = input.next();
        }

        for (int i = 0; i < name.length; i++) {
            int randomPosition = id.nextInt(4);
            String temp = name[i];
            name[i] = name[randomPosition];
            name[randomPosition] = temp;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + " ID = " + numbers[i] + " and name = " + name[i]);
        }
    }
}