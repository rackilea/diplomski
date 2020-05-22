import java.util.*;
class Solution {
    public static void main(String[] args) {
        int[][] tests = {
            {51,71,17,42},
            {42,33,60},
            {51,32,43},
            {101,20,40}
        };

        for(int[] test : tests){
            System.out.println(Arrays.toString(test) + " => " + solve(test));   
        }
    }

    private static int solve(int[] arr){
        Map<Integer,int[]> map = new HashMap<>();
        int max_sum = -1;
        for(int i=0;i<arr.length;++i){
            int temp = arr[i]; 
            int sum = 0;
            while(temp > 0){
                sum += (temp % 10);
                temp /= 10;
            }
            if(!map.containsKey(sum)){
                map.put(sum,new int[3]);
                map.get(sum)[2] = arr[i];
            }else{
                int[] nums = map.get(sum);
                nums[0] = arr[i];
                Arrays.sort(nums);
                max_sum = Math.max(max_sum,Integer.sum(map.get(sum)[1],map.get(sum)[2]));
            }
        }

        return max_sum;
    }
}