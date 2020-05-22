class NumberMatcher extends TypeSafeMatcher<Number> {

    private double value;

    public NumberMatcher(double value) {
        this.value = value;
    }

    @Override
    public void describeTo(Description description) {
        // some description
    }

    @Override
    protected boolean matchesSafely(Number item) {
        return item.doubleValue() == value;
    }

}