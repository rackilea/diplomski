class Solution {

    public static void main(String[] args) throws IOException {
        long max = Long.MIN_VALUE + 1, secondMax = Long.MIN_VALUE;
        int positionMax = -1, positionSecondMax = -1;
        int[] arr = {1,6,2,3,8};

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] + arr[i + 1] > max){
                secondMax = max;
                positionSecondMax = positionMax;
                max = (long)arr[i] + (long)arr[i + 1];
                positionMax = i;
            }
            else if(arr[i] + arr[i + 1] < max && arr[i] + arr[i + 1] > secondMax){
                secondMax = (long)arr[i] + (long)arr[i + 1];
                positionSecondMax = i;
            }
        }

        System.out.println(secondMax + " by elements " + arr[positionSecondMax] + ", " + arr[positionSecondMax + 1]);
    }
}