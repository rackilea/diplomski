import java.util.Arrays;
public class SecondLargest{
  public static void main(String[] args) {
  HW2K();
}
    public static int HW2K() {
        int[] arr = { 50, 40, 60, 20, 10 };
        int i = arr.length; 
        Arrays.sort(arr);
        int secondlargest = arr[i - 2];
        System.out.println(secondlargest);
        return secondlargest;

        }
}