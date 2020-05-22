import java.util.*;
import java.math.BigInteger;


public class Collatz {
    public static void main(String args[]){
        Scanner raj= new Scanner(System.in);
        int k=0;
        System.out.print("n? ");

        BigInteger n = BigInteger.valueOf(raj.nextLong());

        while(n.compareTo(BigInteger.ONE) > 0){
            if(n.testBit(0)){
                n = n.multiply(BigInteger.valueOf(3));
                n = n.add(BigInteger.ONE);
                System.out.println(n);
                k++;
            }
            else {
                n = n.divide(BigInteger.valueOf(2));
                System.out.println(n);
                k++;
            }
        }
        System.out.print("It took " + k + " iterations!");
    }
}