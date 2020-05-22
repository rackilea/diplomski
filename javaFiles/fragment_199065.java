public static Matcher<SomeObject> createPredicate(final List<String> ids) {
    return new Predicate<SomeObject>() {
        public boolean apply(SomeObject specialObj) {
            return ids.contains(specialObj.getTypeId());
        }
    };
}