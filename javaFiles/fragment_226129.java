import java.util.function.Predicate;

public class Condition<T> {

    public void test(Predicate<T> predicate, T aValue, String logIf, String logElse) {
        System.out.println(predicate.test(aValue) ? logIf : logElse);
    }


    public static void main(String[] args) {

        Condition<Integer> conditionInteger = new Condition<>();
        conditionInteger.test( v ->  v < 10, 15, "Log If with an integer", "log else with an integer");

        Condition<String> conditionString = new Condition<>();
        conditionString.test( v -> v.length() < 10, "a great String", "Log If with a string", "log else with a string");
    }
}