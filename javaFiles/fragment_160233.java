public void loop1() {
    int n = 0;
    int[] nums = new int[]{1};
    int value = 2;

    // n >= 0 is true
    // nums[n] == value is false
    // Therefore while condition is false and n is NOT decremented
    while(n>= 0 && nums[n] == value){  
        n--;
    }
    // n = 0
    System.out.println("n=" + n);
}