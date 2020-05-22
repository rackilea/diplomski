public static int[] notAlone(int[] nums, int val) {
    for(int k = 1 ; k<nums.length - 1; k++)
    {
        if(nums[k]==val && nums[k-1] != nums[k] && nums[k] != nums[k+1])
            nums[k] = Math.max (nums[k-1], nums[k+1]);
    }
    return nums;
}