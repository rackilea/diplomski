import java.math.BigInteger;

public class Factorial {
public static void main(String args[]) {

    BigInteger fact=BigInteger.ONE;
    int number = 1000;
    BigInteger bigNum =new BigInteger(Integer.toString(number));
    for(int i=2;i<=number;i++){
        fact = fact.multiply(bigNum);
        bigNum=bigNum.subtract(BigInteger.ONE);
    }
    System.out.println("Factorial of " + number + " is: " + fact);
}
}