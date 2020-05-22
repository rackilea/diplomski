public int[] zeroMax(int[] nums) {
    int acum = 0;
    int i = 0;
    for (i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 != 0 && nums[j] > acum) {
                    acum = nums[j];
                }
            }
            nums[i] = acum;
            acum = 0;
        }

    }
    return nums;
}