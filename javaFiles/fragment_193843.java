import java.util.*;
import java.math.*;

public class Rsa {

    private static final Scanner sc = new Scanner(System.in);

    private int p, q, n, z, d = 0, e, i;

    public Rsa() {
        System.out.println("Enter 1st prime number p");
        p = sc.nextInt();
        System.out.println("Enter 2nd prime number q");
        q = sc.nextInt();

        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);

        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) // e is for public key exponent
            {
                break;
            }
        }
        //e should be in the range 1-z
        System.out.println("the value of e = " + e);

        // calculate d
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) //d is for private key exponent
            {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of d = " + d);
    }

    private static int gcd(int e, int z) {
        if (e == 0) {
            return z;
        } else {
            return gcd(z % e, e);
        }
    }

    double encrypt(int msg) {
        //Encrypting  C = msg ^e mod n
        return (Math.pow(msg, e)) % n;
    }

    double[] encrypt(String msg) {
        int[] charactersAsNumbers = new int[msg.length()];
        for(int i = 0; i < msg.length(); i++) {
            charactersAsNumbers[i] = msg.codePointAt(i);
        }
        System.out.println("Plain text as sequence of numbers: " + Arrays.toString(charactersAsNumbers));

        double[] encryptedMsg = new double[msg.length()];
        for(int i = 0; i < charactersAsNumbers.length; i++) {
            encryptedMsg[i] = encrypt(charactersAsNumbers[i]);
        }
        return encryptedMsg;
    }

    BigInteger decrypt(double encrypted) {
        //converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
        //converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(encrypted).toBigInteger();

        //Decrypt , P = Cˆd mod N , msgback = P
        return (C.pow(d)).mod(N);
    }

    String decrypt(double[] encrypted) {
        StringBuilder builder = new StringBuilder();
        for(double encryptedCharacter: encrypted) {
            BigInteger decryptedCharacter = decrypt(encryptedCharacter);
            builder.append(Character.toChars(decryptedCharacter.intValue()));
        }
        return builder.toString();
    }

    public static void main(String args[]) {
        System.out.println("Enter the text to be encrypted and decrypted");
        String msg = sc.nextLine();
        Rsa rsa = new Rsa();

        double[] c = rsa.encrypt(msg);
        System.out.println("Encrypted message is: " + Arrays.toString(c));

        String msgBack = rsa.decrypt(c);
        System.out.println("Decrypted message is: " + msgBack);
    }
}