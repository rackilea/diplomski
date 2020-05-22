public class Solution {
    public int reverse(int A) {
        //if(A < Integer.MIN_VALUE || A > Integer.MAX_VALUE) return 0;
        boolean neg = A < 0;
        A = Math.abs(A);
        long ret = 0;
        while(A != 0){
            ret = ret*10 + A%10;
            A = A/10;
        }
        if(ret > Integer.MAX_VALUE) return 0;
        return neg ? -(int)ret : (int)ret;
    }
}