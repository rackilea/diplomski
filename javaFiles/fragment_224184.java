jcomeau@intrepid:/tmp$ cat test.java; javac test.java; java test
import java.math.BigInteger;
public class test {
 public static void main(String[] args) {
  System.out.println("one bits: " + new BigInteger("0f0f0f0f0f0f0", 16).bitCount());
 }
}
one bits: 24