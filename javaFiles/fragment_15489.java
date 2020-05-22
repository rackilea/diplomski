private Matcher<Member> name(String name) {
    return new FeatureMatcher<Member, String>(equalTo(name), "name", "name") {
        @Override
        protected String featureValueOf(Member actual) {
            return actual.getName();
        }
    };
}