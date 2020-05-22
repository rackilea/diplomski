public static void main(String[] args) {

    int[] nums = new int[1001];
    for(int y=0;y<nums.length;y++) {
        nums[y]= y + 2000;
    }

    System.out.println(Arrays.toString(nums));
}