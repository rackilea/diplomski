public class MyCustomMapFunction implements Function<HashMap<String, Integer>, Integer> {
    @Override
    public Integer apply(final HashMap<String, Integer> m)
    {
        return m.get("b");
    }
}