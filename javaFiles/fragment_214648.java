import java.util.Scanner;
import java.util.ArrayList;

Scanner in = new Scanner(System.in);
ArrayList<Double> arr = new ArrayList<Double>();

while (in.hasNextDouble()) {
    arr.add(in.nextDouble());

    System.out.println("Continue? y = 1, n = 2");
    if (in.hasNextInt() && in.nextInt() == 2) // assumes any non-2 answer is "Yes"
        break;
}