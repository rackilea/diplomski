public static Matcher<View> withBgColor(final int color) {
    Checks.checkNotNull(color);
    return new BoundedMatcher<View, LinearLayout>(LinearLayout.class) {
        @Override
        public boolean matchesSafely(LinearLayout row) {
            return color == ((ColorDrawable) row.getBackground()).getColor();
        }
        @Override
        public void describeTo(Description description) {
            description.appendText("with text color: ");
        }
    };
}