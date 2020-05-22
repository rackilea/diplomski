import java.util.Arrays;

class Main{
    static int MAX_VALUE = 1048575;
    static int[] fArr = new int[MAX_VALUE];

    public static void main(String[] args){
        int[] arr = new int[]{1,1,3,2,4,5,6};
        System.out.println("Original array:    "+toString(arr));
        int[][] leftRight = lesserLeftRight(arr);
        System.out.println("Lesser left count: "+toString(leftRight[0]));
        System.out.println("Greater right cnt: "+toString(leftRight[1]));
    }

    public static String toString(int[] arr){
        String result = "[";
        for(int num: arr){
            if(result.length()!=1){
                result+=", ";
            }
            result+=num;
        }
        result+="]";
        return result;
    }

    public static void reset(){
        Arrays.fill(fArr,0);
    }

    public static void update(int idx, int val){
        while(idx < MAX_VALUE){
            fArr[idx]+=val;
            idx += (idx & -idx);
        }
    }

    public static int cntSum(int idx){
        int result = 0;
        while(idx > 0){
            result += fArr[idx];
            idx -= (idx & -idx);
        }
        return result;
    }

    public static int[] lesserLeftCount(int[] arr){
        reset();
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = cntSum(arr[i]-1);
            if(cntSum(arr[i])==result[i]) update(arr[i],1);
        }
        return result;
    }

    public static int[][] lesserLeftRight(int[] arr){
        int[] left = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            left[i] = arr[i];
            if(min>arr[i]) min=arr[i];
        }
        for(int i=0; i<arr.length; i++) left[i]+=min+1;
        left = lesserLeftCount(left);

        int[] right = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            right[i] = arr[arr.length-1-i];
            if(max<right[i]) max=right[i];
        }
        for(int i=0; i<arr.length; i++) right[i] = max+1-right[i];
        right = lesserLeftCount(right);
        int[] rightFinal = new int[right.length];
        for(int i=0; i<right.length; i++) rightFinal[i] = right[right.length-1-i];
        return new int[][]{left, rightFinal};
    }
}