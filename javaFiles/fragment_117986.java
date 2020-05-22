import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static ArrayList<BigInteger> fibList = new ArrayList<BigInteger>();

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        fibList.add(BigInteger.valueOf(0));
        fibList.add(BigInteger.valueOf(1));

        while(in.hasNextLine()) {
            BigInteger nextBigDecimal = in.nextBigInteger();
            System.out.println("input:" + nextBigDecimal);
            System.out.println("isFibo: " + checkFibo(nextBigDecimal));
            System.out.println(fibList);
        }
    }

    public static boolean checkFibo(BigInteger i) {
        int lastIndex = fibList.size() - 1;
        int compareRes = i.compareTo(fibList.get(lastIndex));

        System.out.println("Last fib num: " + fibList.get(lastIndex));
        System.out.println("CompareRes: " + compareRes);

        boolean isFibo = false;

        switch(compareRes) {
            case 0:
                isFibo = true;
                break;
            case 1:
                BigInteger newFib = fibList.get(lastIndex-1).add(fibList.get(lastIndex));
                fibList.add(newFib);
                isFibo = checkFibo(i);
                break;
            case -1:
                isFibo = fibList.contains(i);
                break;
        }
        return isFibo;
    }
}