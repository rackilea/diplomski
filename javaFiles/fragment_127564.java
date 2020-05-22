Matcher<List<?>> deepEqual(List<?> expected) {
    return new FeatureMatcher<List<?>, List<?>>(equalTo(arrayToList(expected))
                                               ,"items", "") {
        @Override
        protected List<?> featureValueOf(List<?> actual) {
            return arrayToList(actual);
        }
    };
}

static List<?> arrayToList(List<?> it) {
    List<Object> result = new ArrayList<>();
    for (Object item : it) {
        result.add(isArray(item) ? Arrays.asList(array(item)) : item);
    }
    return result;
}

static boolean isArray(Object it) {
    return it != null && it.getClass().isArray();
}

static Object[] array(Object array) {
    int length = Array.getLength(array);
    Object[] result = new Object[length];
    for (int i = 0; i < length; i++) {
        result[i] = Array.get(array, i);
    }
    return result;
}