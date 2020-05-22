import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List <Integer> intList=new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the integers separated by a space: ");
        String[] strNums = null;
        if (scanner.hasNextLine()) {
            strNums = scanner.nextLine().split(" ");
        }
        if (strNums != null) {
            for (String strNum: strNums) {
                try {
                    intList.add(Integer.parseInt(strNum.trim()));
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    break;
                }
            }
            System.out.println(intList);

            //You can even get an array out of the list as follows:
            Integer[] nums = intList.toArray(new Integer[0]);
            System.out.println(Arrays.toString(nums));
        }
    }
}