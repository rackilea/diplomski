import java.util.Arrays;

public class Graph26 {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 3;
    private static final int E = 4;
    private static final int F = 5;
    private static final int G = 6;
    private static final int H = 7;
    private static final int I = 8;
    private static final int J = 9;
    private static final int K = 10;
    private static final int L = 11;

    private final static boolean rule1(final int[] n) {
        return n[A] + n[C] + n[F] + n[H] == 26;
    }

    private final static boolean rule2(final int[] n) {
        return n[A] + n[D] + n[G] + n[K] == 26;
    }

    private final static boolean rule3(final int[] n) {
        return n[H] + n[I] + n[J] + n[K] == 26;
    }

    private final static boolean rule4(final int[] n) {
        return n[B] + n[C] + n[D] + n[E] == 26;
    }

    private final static boolean rule5(final int[] n) {
        return n[B] + n[F] + n[I] + n[L] == 26;
    }

    private final static boolean rule6(final int[] n) {
        return n[E] + n[G] + n[J] + n[L] == 26;
    }

    private final static boolean rule7(final int[] n) {
        return n[A] + n[B] + n[E] + n[H] + n[K] + n[L] == 26;
    }

    private final static boolean isValid(final int[] nodes) {
        return rule1(nodes) && rule2(nodes) && rule3(nodes) && rule4(nodes)
                && rule5(nodes) && rule6(nodes) && rule7(nodes);
    }

    class Permutation {
        private final int[] o;
        private boolean perms = true;

        public boolean hasPerms() {
            return perms;
        }

        Permutation(final int[] obj) {
            o = obj.clone();
        }

        private int[] nextPerm() {
            int temp;
            int j = o.length - 2;
            while (o[j] > o[j + 1]) {
            j--;
            if (j < 0) {
            perms = false;
            break;
            }
            }
            if (perms) {
            int k = o.length - 1;
            while (o[j] > o[k]) {
            k--;
            }
            temp = o[k];
            o[k] = o[j];
            o[j] = temp;
            int r = o.length - 1;
            int s = j + 1;
            while (r > s) {
            temp = o[s];
            o[s] = o[r];
            o[r] = temp;
            r--;
            s++;
            }
            }
            return o.clone();
        }
    }

    public static void main(final String[] args) {
        int[] nodes = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        final Graph26 graph = new Graph26();
        final Permutation p = graph.new Permutation(nodes);
        int i = 0;
        while (p.hasPerms()) {
        if (isValid(nodes)) {
        System.out.println(Arrays.toString(nodes));
        }
        i++;
        nodes = p.nextPerm();
        }
        System.out.println(i);
    }
}