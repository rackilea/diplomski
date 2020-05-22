import java.util.Arrays;

public class Main {
    public static class KMP {
        private final int F[];
        private final int[] needle;

        public KMP(int[] needle) {
            this.needle = needle;
            this.F = new int[needle.length + 1];

            F[0] = 0;
            F[1] = 0;
            int i = 1, j = 0;
            while (i < needle.length) {
                if (needle[i] == needle[j])
                    F[++i] = ++j;
                else if (j == 0)
                    F[++i] = 0;
                else
                    j = F[j];
            }
        }

        public int find(int[] haystack) {
            int i = 0, j = 0;
            int n = haystack.length, m = needle.length;

            while (i - j <= n - m) {
                while (j < m) {
                    if (needle[j] == haystack[i]) {
                        i++;
                        j++;
                    } else break;
                }
                if (j == m) return i;
                else if (j == 0) i++;
                j = F[j];
            }
            return -1;
        }
    }

    public static boolean rotateAndCompare(int[] fst, int[] snd) {
        int[] fst2 = new int[fst.length * 2];
        System.arraycopy(fst, 0, fst2, 0, fst.length);
        System.arraycopy(fst, 0, fst2, fst.length, fst.length);

        int[] snd2 = Arrays.copyOf(snd, fst.length);
        return new KMP(snd2).find(fst2) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(rotateAndCompare(new int[]{1, 2, 3}, new int[]{3, 1, 2, 4}));
        System.out.println(rotateAndCompare(new int[]{1, 2, 2}, new int[]{3, 1, 2, 4}));
    }
}