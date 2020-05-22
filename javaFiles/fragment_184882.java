private Matcher<Object> hasPropertiesEqual(final String propA, final String propB) {
    return new TypeSafeMatcher<Object>() {


        public void describeTo(final Description description) {
            description.appendText("The propeties are not equal");
        }

        @Override
        protected boolean matchesSafely(final Object object) {

            Object propAValue, propBValue;
            try {
                propAValue = PropertyUtils.getProperty(object, propA);
                propBValue = PropertyUtils.getProperty(object, propB);
            } catch(Exception e) {

                return false;
            }

            return propAValue.equals(propBValue);
        }
    };
}