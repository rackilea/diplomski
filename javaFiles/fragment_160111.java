public class Solution {
    public static void climbStairsByComputingAllNextSteps(int n) {
        processNextClimbingByComputingAllNextSteps(0, n);
    }
    private static int processNextClimbingByComputingAllNextSteps(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return
        processNextClimbingByComputingAllNextSteps(i + 1, n) +
        processNextClimbingByComputingAllNextSteps(i + 2, n);
    }

    public static int climbStairsDynamically(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
    long startTime, diffTime;
    int steps;

    try {
        steps= Integer.parseInt(args[0]);
    } catch (Exception e) {
        steps=10;
    }

    System.out.println("Time spent for " + steps + " step(s):");
    System.out.print("\t - climbStairsByComputingAllNextSteps(): ");
    startTime = System.nanoTime();
    climbStairsByComputingAllNextSteps(steps);
    diffTime = System.nanoTime() - startTime;
    System.out.println(diffTime + " nanoseconds");
    System.out.print("\t - climbStairsDynamically(): ");
    startTime = System.nanoTime();
    climbStairsDynamically(steps);
    diffTime = System.nanoTime() - startTime;
    System.out.println(diffTime + " nanoseconds");

    }

}