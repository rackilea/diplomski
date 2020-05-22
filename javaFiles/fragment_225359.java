import java.util.ArrayList;
import java.util.List;

public class NumbersToArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        int number = 35779;

        while (number > 0) {
            list.add(0, number % 10);

            number /= 10;
        }

        System.out.println(list);
    }
}