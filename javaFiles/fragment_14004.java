public class MatchParameter<T> {
    boolean expectMatch = true;

    T valueToCheck;

    BiPredicate<Foo, T> predicate;

    public MatchParameter(T value, boolean shouldMatch, BiPredicate<Foo, T> function) {
        this.expectMatch = shouldMatch;
        this.valueToCheck = value;
        this.predicate = predicate;
    }

    public boolean matches(Predicate<T> matcher) {
        return matcher.test(valueToCheck) == expectMatch;
    }
}