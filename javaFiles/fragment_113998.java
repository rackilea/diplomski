/**
 * 
 * @author hovercraft
 * {@link http://stackoverflow.com/q/31303332/522444}
 */
public class Cipher2 {
   // just ban "magic" numbers
   public static final int A_VALUE = (int) 'a';
   public static final int Z_TO_A = (int) ('z' - 'a') + 1;
   // alphabet frequency
   static double[] table = { 8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0, 0.2,
         0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0, 6.3, 9.1, 2.8, 1.0, 2.4, 0.2,
         2.0, 0.1 };

   // convert letter to number
   static int let2nat(char c) {
      return ((int) c) - A_VALUE;
   }

   // convert number to letter
   static char nat2let(int code) {
      return (char) (code + A_VALUE);
   }

   // shift a letter to another letter shftAmt spaces away
   static char shift(int shftAmt, char c) {
      if (let2nat(c) < 0 || let2nat(c) > Z_TO_A - 1) {
         return c;
      } else {
         // do a safe shift
         int result = (let2nat(c) + shftAmt) % Z_TO_A;
         result += Z_TO_A;
         result %= Z_TO_A;
         return nat2let(result);
      }
   }

   private static String crack(String encrypted) {
      int[] letterCount = new int[Z_TO_A];
      for (char c : encrypted.toCharArray()) {
         letterCount[let2nat(c)]++;
      }
      double[] letterFrequency = new double[Z_TO_A];
      for (int i = 0; i < letterCount.length; i++) {
         letterFrequency[i] = (double) letterCount[i] * 100 / Z_TO_A;
      }

      int index = 0;
      double minChiSqrSum = calcChiSqrSum(index, letterFrequency);
      for (int i = 0; i < Z_TO_A; i++) {
         double chiSqrSum = calcChiSqrSum(i, letterFrequency);
         if (chiSqrSum < minChiSqrSum) {
            minChiSqrSum = chiSqrSum;
            index = i;
         }
      }
      return encode(index, encrypted);
   }

   private static double calcChiSqrSum(int i, double[] letterFrequency) {
      double sum = 0.0;
      for (int j = 0; j < letterFrequency.length; j++) {
         double observed = letterFrequency[j];
         int tableIndex = (i + j + Z_TO_A) % Z_TO_A;
         double expected = table[tableIndex];
         double delta = observed - expected;
         double chiSqr = delta * delta / expected;
         sum += chiSqr;
      }
      return sum;
   }

   private static String encode(int shift, String text) {
      StringBuilder sb = new StringBuilder();
      for (char c : text.toCharArray()) {
         // convert all upper case to lower case
         // this is a judgment call on my part
         c = Character.toLowerCase(c);
         if (let2nat(c) >= 0 && let2nat(c) < Z_TO_A) {
            sb.append(shift(shift, c));
         }
      }
      return sb.toString();
   }

   public static void main(String[] args) {
      String test1 = "Hello world. How is it going? It's going fine with me";
      String test2 = "When, in the course of human events, it becomes "
            + "necessary for one portion of the family of man to assume "
            + "among the people of the earth a position different from "
            + "that which they have hitherto occupied, but one to which "
            + "the laws of nature and of nature's God entitle them, "
            + "a decent respect to the opinions of mankind";

      // let's throw it for a complete loop: ... but it works!
      String test3 = "Lorem ipsum dolor sit amet, consectetur adipiscing "
            + "elit, sed do eiusmod tempor incididunt ut labore et dolore "
            + "magna aliqua. Ut enim ad minim veniam, quis nostrud "
            + "exercitation ullamco laboris nisi ut aliquip ex ea commodo "
            + "consequat. Duis aute irure dolor in reprehenderit in "
            + "voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
            + "Excepteur sint occaecat cupidatat non proident, sunt in "
            + "culpa qui officia deserunt mollit anim id est laborum.";

      // an unfair test:
      String test4 = "abcdefghijklmnopqrstuvwxyz";

      String test5 = "haskellisfun";
      String[] tests = { test1, test2, test3, test4, test5 };

      for (String test : tests) {
         System.out.println(crack(encode(6, test)));
      }
   }
}