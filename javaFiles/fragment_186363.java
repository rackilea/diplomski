private Matcher<BMF> stringsTo(final String desired) {
    return new TypeSafeMatcher<BMF>() {
        protected boolean matchesSafely(BMF item) {
            return item.toString().equals(desired);
        }

        public void describeTo(Description description) {
            description.appendText("should stringify as ").appendValue(desired);
        }

        protected describeMismatchSafely(BMF item, Description description) {
             description.appendText(" was ").appendValue(item.toString());
        }
    }
}