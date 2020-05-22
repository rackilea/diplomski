import java.util.ArrayList;
import java.util.List;

public class MoneyChangers {
    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        getCombos(results, 28, 0);
        System.out.println(results);
    }

    public static void getCombos(List<String> results, int target, int dimesCount) {
        int pennies = target - 10 * dimesCount;
        if (pennies < 0) {
            return;
        }
        getCombosForDimesFixed(results, target, dimesCount, 0);

        // This is tail recursion, which is really just a loop.  Do it again with one more dime.
        getCombos(results, target, dimesCount+1);
    }

    private static void getCombosForDimesFixed(List<String> results, int target, int dimesCount, int nickelsCount) {
        int pennies = target - 10 * dimesCount - 5 * nickelsCount;
        if (pennies < 0) {
            return;
        }
        results.add("\n" + dimesCount + "d, " + nickelsCount + "n, " + pennies + "p");
        getCombosForDimesFixed(results, target, dimesCount, nickelsCount+1);   // tail recursion again
    }
}