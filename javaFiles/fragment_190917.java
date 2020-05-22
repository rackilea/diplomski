private int numHelper(int[] nums, int atIndex, int result) {
    if (atIndex == nums.length) {
        return result;
    }

    int check = result;                   // save previous result
    result = result * 10 + nums[atIndex];

    // result might cycle through Integer.MIN_VALUE after hitting the Integer.MAX_VALUE
    if(check > result) {
        throw new NumberFormatException();
    }
    return numHelper(nums, ++atIndex, result);
}