int[] nums = new int[] {num1, num2, num3, num4, num5};
int smallest = nums[0];
int largest = nums[0];
for(int i = 1; i < nums.length; i++) {
    if(nums[i] < smallest) {
        smallest = nums[i];
    }
    if(nums[i] > largest) {
        largest = nums[i];
    }
}