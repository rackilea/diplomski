import java.util.*;



  public class BitSet {
        public static void main(String args[]) {
           BitSet[] flags = new BitSet[5];
        for (int i = 0; i < flags.length; i++) {
           flags[i] = new BitSet(5);
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i % j == 0) {
                  flags[j - 1].set(i);
                }
            }
        }

        for (int i = 0; i < flags.length; i++) {
            System.out.printf("Numbers divisible by %d: %s%n", i + 1, flags[i]);
        }
    }