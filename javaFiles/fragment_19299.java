@SuppressWarnings({"rawtypes", "unchecked"})
public static Matcher<double[]> isArrayCloseTo(double[] expected) {
    final double DELTA = 1e-10;
    List<Matcher<Double>> matchers = new ArrayList<>();
    for (double d : expected)
        matchers.add(new IsCloseTo(d, DELTA));

    return new CustomTypeSafeMatcher<double[]>("array that is close to" + Arrays.toString(expected)) {
        @Override
        protected boolean matchesSafely(double[] actual) {
            return new IsArray<Double>(matchers.toArray(new Matcher[matchers.size()]))
                    .matchesSafely(Arrays.stream(actual).boxed().toArray(Double[]::new));
        }
    };
}