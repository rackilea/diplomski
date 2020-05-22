public static void main(String[] args) {
    int[] arr1 ={2, 5, 10, 4};
    int[] arr2 = {2, 5, 10, 4};
    System.out.println(groupNoAdj(0, arr1, 12)); // prints true
    System.out.println(groupNoAdj(0, arr2, 7));  // prints false
}

public static boolean groupNoAdj(int start, int[] nums, int target) {

    if(target == 0)
        return true;

    if(start == nums.length)
        return target==0;

    if(start == nums.length-1)
        return target-nums[start] == 0;

    return
            groupNoAdj(start+2, nums, target-nums[start]) || // either pick the "current" item (and skip the "next") 
            groupNoAdj(start+1, nums, target);               // or don't pick it
}