import java.util.Scanner;

public class Prueba {

static int alpha[] = new int[20];
static Scanner scan = new Scanner(System.in);

public static void main(String args[]) {

    int array[] = new int[20];
    array = inputArray(alpha);

}

public static int[] inputArray(int alpha[]) {
    for (int i = 0; i < alpha.length; i++) {
        alpha[i] = scan.nextInt();
        System.out.println(alpha[i]);
    }
    return alpha;

}