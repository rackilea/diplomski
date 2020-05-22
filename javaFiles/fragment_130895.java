private Supplier<Map<Range<Double>, String> cachedMap = 
    Suppliers.memoizeWithExpiration(
        new Supplier<Map<Range<Double>, String>() {
            public Map<Range<Double>, String> get() {
                return readMappingFromS3();
            }
        }, 10, TimeUnit.MINUTES);

public String getContentLevelForScore(Score score) {
    Map<Range<Double>, String> scoreMap = cachedMap.get();
    // etc.
}