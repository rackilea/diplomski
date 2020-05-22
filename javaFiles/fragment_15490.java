private Matcher<Iterable<? extends Member>> hasNames(String[] expectedNames) {
    return containsInAnyOrder(Arrays.stream(expectedNames).map(name -> name(equalTo(name))).collect(Collectors.toList()));
}

private Matcher<Member> name(Matcher<String> nameMatcher) {
    return new FeatureMatcher<Member, String>(nameMatcher, "name", "name") {
        @Override
        protected String featureValueOf(Member actual) {
            return actual.getName();
        }
    };
}