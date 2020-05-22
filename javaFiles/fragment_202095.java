public class TestLambda {

    protected static <K, V> Map<K, V> newMap(final Function<K, V> loader) {
        return new HashMap<>();
    }

    private final Map<Integer, Integer> working = newMap(key -> {

        final List<String> strings = new ArrayList<>();

        final String[] array = strings.toArray(new String[strings.size()]);
        foo(array);

        return null;
    });

    private final Map<Void, Void> notWorking = newMap(key -> {

        final List<String> strings = new ArrayList<>();

        // This line seems to be the root of all evils
        foo(strings.toArray(new String[strings.size()]));

        return null;
    });

    private void foo(final Integer[] x) {}
    private void foo(final String[] x) {}
}