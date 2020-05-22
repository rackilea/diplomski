public class Main{
    public static void main(String[] args){
        int[] nums = { 6, 9, 11, 1, 10 };

        int max = nums[0];
        int secmax = nums[0];

        for(int x=1; x<nums.length; x++) {
            if(nums[x]>max ) {
                secmax = max;
                max=nums[x];
            }else if(nums[x]>secmax){
                secmax=nums[x];
            }
         }
        System.out.println("1st H value: " + max);
        System.out.println("2nd H Value: " + secmax);
    }
}