public Map<String, Collection<String>> convert(CategoryValuePair[] values) {
    Multimap<String, String> mmap = ArrayListMultimap.create();
    for (CategoryValuePair value : values) {
        mmap.put(value.category, value.value);
    }
    return mmap.asMap();
}