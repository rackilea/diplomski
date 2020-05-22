import java.util.*;
import java.math.BigInteger;
public class LastNumberofFibo {


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        BigInteger bi = sc.nextBigInteger();


        System.out.println(fib(bi));
    }


    public static BigInteger fib(BigInteger n) {
        int m = 10;
        BigInteger sixty = new BigInteger("60");
        int k = (n.mod(sixty)).intValue();
        int ans = 0;

        if(k == 0) {
            ans = 0;
        } else if(Math.abs(k) <= 2) {
            ans = 1;
        } else {
            int km1 = 1;
            int km2 = 1;

            for(int i = 3; i <= Math.abs(k); ++i) {
                ans = (km1 + km2)%m;
                km2 = km1;
                km1 = ans;
            }
        }

        if(k<0 && k%2==0) { ans = -ans; }
        return new BigInteger("" + ans);
    }

}