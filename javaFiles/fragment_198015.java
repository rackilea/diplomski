import java.util.ArrayList;

public class Pow2IndexSum {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<Integer>();

        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);
        intArray.add(6);
        intArray.add(7);
        intArray.add(8);
        intArray.add(9);
        intArray.add(10);

        int total = 0;

        for (int x = 1; x < intArray.size(); x *= 2) {
            total += intArray.get(x);
        }

        System.out.println(total);
    }
}