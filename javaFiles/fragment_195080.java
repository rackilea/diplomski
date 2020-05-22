import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(tenRun(new int[] { 2, 10, 3, 4, 20, 5 })));
    }

    public static int[] tenRun(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 10 == 0) {
                if (nums[i + 1] % 10 != 0) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return nums;
    }
}