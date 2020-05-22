public boolean no14(int[] nums) {
    boolean ones = false, fours = false;

    for(int i = 0; i &lt; nums.length; i++) {
        if(nums[i] == 1) {
            ones = true;
        } else if(nums[i] == 4) {
            fours = true;
        }
    }
    return (!ones) || (!fours);
}