public static void main(String[] args) {
    int[]nums = {2,4,6,8,7}; // you can initialize the array like this
    int target=7;

    System.out.println(findValue(target, nums));

  }



  private static int findValue(int target, int[] nums) {
    for(int i=0; i<nums.length;i++){
     if(nums[i]==target)
       return i;

        }
        return -1;
    }