import java.util.*;

public class ArrayWith10Numbers {

    public static void main(String[] args) {
        final int TOTAL_NUMBERS = 10;
        System.out.print("Enter " + TOTAL_NUMBERS + " values: ");

        Scanner input = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < TOTAL_NUMBERS; i++) {
            set.add(input.nextInt());
        }

        StringBuilder sb = new StringBuilder();     
        for (int n : set) {
            sb.append(n).append(' ');
        }

        System.out.println("Numbers without duplicates: " + sb);
    }
}