import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    public static int solve(int[][] P) {
        int a = 1, b = 1;
        for (int i = 1; i < P.length; i++) {
            int na = 1 + min(
                    abs(P[i][0] - P[i - 1][0]) + a,
                    abs(P[i][0] - P[i - 1][1]) + b);

            int nb = 1 + min(
                    abs(P[i][1] - P[i - 1][0]) + a,
                    abs(P[i][1] - P[i - 1][1]) + b);

            a = na;
            b = nb;
        }
        return min(a, b);
    }

    public static void main(String... args) {
        System.out.println(solve(new int[][]{
                {3, 6},
                {2, 8},
                {4, 5},
                {7, 8},
                {3, 10},
        }));


        System.out.println(solve(new int[][]{
                {4, 7},
                {2, 9},
                {8, 11}
        }));
    }
}