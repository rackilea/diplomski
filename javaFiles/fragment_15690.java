import java.util.Scanner;

public class Solution1 {
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int t = scan.nextInt(); // number of test cases
        for (int i = 0; i < t; ++i) {
            final long maximumDamage = scan.nextLong();
            final char[] a = scan.next().toCharArray();

            long minDamage = 0; for (final char c : a) if ('S' == c) minDamage++;

            if (maximumDamage >= minDamage) {
                long hacks = 0;
                while (damageComputer(a) > maximumDamage) {
                    int swappos;
                    while ((swappos = swappos(a)) >= 0) {
                        a[swappos] = 'S'; a[swappos + 1] = 'C'; hacks++;
                    }
                }
                System.out.println("Case #" + i + ": " + hacks);
            } else
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        }
    }
    public static long damageComputer(final char[] a) {
        long strength = 1, damage = 0;
        for (final char c : a) if ('C' == c) strength <<= 1; else damage += strength;
        return damage;
    }
    public static int swappos(final char[] a) {
        for (int i = a.length - 2; i > 0; --i)
            if ((a[i] == 'C') && (a[i + 1] == 'S')) return i;
        return -1;
    }
}