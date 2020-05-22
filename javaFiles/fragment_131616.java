import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

public static void main(String[] args) {
    //Must be Integer class
    Integer[] nums = { 1, 2, 3, 0, 1, 2, 3, 1, 4, 4, 4, 0, 0, 1, 2, 1, 0,
            0, 4 };

    List<Integer> list = Arrays.asList(nums);
    // Before sort
    System.out.println("Before sort :" + list.toString());

    // Sort 'list' items
    Collections.sort(list);
    // After sort
    System.out.println("After sort :" + list.toString());
}