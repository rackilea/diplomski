import java.util.function.IntPredicate;

public class Test {
    public static void main(String[] args) {
        int testValue = 23;
        handleSomething(true, testValue, Test::checkIfZero);
        handleSomething(false, testValue, Test::checkIfLargerThanZero);
    }

    private static boolean checkIfZero(int value) {
        if (value == 0)
            return true;
        return false;
    }

    private static boolean checkIfLargerThanZero(int value) {
        if (value > 0)
            return true;
        return false;
    }

    private static void handleSomething(boolean test, int value, IntPredicate function) {
        if (test) {
            System.out.println("Ignore");
            return;
        }

        if (function.test(value))
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }
}