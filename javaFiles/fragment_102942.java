public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 12, 13};
        int res = checkArray(nums, 0, nums.length - 1);
        System.out.println("res = " + res);
    }

    public static int checkArray(int[] nums, int start, int end) {
        if (end - start < 2) {
            return end;
        } else {
            int middle = (start + end) / 2;
            int a = nums[start];
            int b = nums[middle];
            if (b - a != middle - start) {
                return checkArray(nums, start, middle);
            } else {
                return checkArray(nums, middle, end);
            }
        }
    }
}