public void loop2() {
    int n = 0;
    int[] nums = new int[]{1};
    int value = 2;

    // n >= 0 is true
    // nums[n--] == value executes in 2 steps:
    //  1.  nums[n] == value
    //  2.  n = n - 1 WILL EXECUTE regardless of result being true/false
    while(n>= 0 && nums[n--] == value){  
    }
    // n = -1
    System.out.println("n=" + n);
}