// Helper method created so that the wildcard can be captured
// through type inference.
private <T> void helper(List<T> data) {
    Map<Class<?>, Converter<T>> converterMap = null;
    List<String> stringData = null;

    for (T datum : data) {
        stringData.add(converterMap.get(datum.getClass()).asString(datum));
    }
}