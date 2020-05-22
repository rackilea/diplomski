import java.math.*;
public class T {
    public static void main(String[] args) {
        for (String s: args) {
            // build from base-16 string representation
            BigInteger bi = new BigInteger(s, 16); 
            System.out.println("The decimal representation of \n\t"
                + s + " is \n\t" + bi);
            // (bi.toString() generates base-10 strings)
        }
    }
}