jcomeau@intrepid:/tmp$ cat test.java; javac test.java; java test 0xf0f0f0f0f0f0 0x200 200 1 0
import java.math.BigInteger;
public class test {
 public static void main(String[] args) {
  BigInteger number = null;
  for (String arg : args) {
   if (arg.startsWith("0x")) {
    number = new BigInteger(arg.substring(2), 16);
   } else {
    number = new BigInteger(arg);  // decimal by default
   }
   System.out.println("one bits in " + arg + ": " + number.bitCount());
  }
 }
}
one bits in 0xf0f0f0f0f0f0: 24
one bits in 0x200: 1
one bits in 200: 3
one bits in 1: 1
one bits in 0: 0