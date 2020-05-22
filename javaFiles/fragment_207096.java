public static void main(String[] args) {
    int x = 0;
    int[] y = {2, 4, 8};
    int k = 10;

    boolean result = groupSum(x, y, k);
    System.out.println(result);
}

public static boolean groupSum(int start, int[] nums, int target) {
    System.out.println("groupSum(" + start + ", " + Arrays.toString(nums) + ", " + target + ")");
    if (target == 0)
        return true;
    if (start == nums.length)
        return false;
    if (groupSum(start + 1, nums, target - nums[start]))
        return true;
    System.out.print("or ");
    return groupSum(start + 1, nums, target);
}