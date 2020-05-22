import java.security.SecureRandom;

public class Main{
    public static void main(String[] args){

      SecureRandom seedMaker = new SecureRandom();  
      byte[] seed = seedMaker.generateSeed(20);
      SecureRandom r1 = new SecureRandom(seed);
      SecureRandom r2 = new SecureRandom(seed);

      byte[] b1 = new byte[4];
      byte[] b2 = new byte[4];
      for (int i=0;i<10;i++) {
        r1.nextBytes(b1);
        r2.nextBytes(b2);

        System.out.println(java.util.Arrays.toString(b1)+" == "+java.util.Arrays.toString(b2));
      }
    }
}