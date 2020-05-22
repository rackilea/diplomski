public class MyCustomFilterPredicate implements Predicate<HashMap<String, Integer>> {
    @Override
    public boolean test(final HashMap<String, Integer> m)
    {
        return m.get("a") > 10;
    }
}