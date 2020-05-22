private static final Map<String, Category> CATEGORIES_BY_STRING;
static {
    Map<String, Category> backingMap = new HashMap<String, Category>();
    backingMap.put("producer", Category.CATEGORY_PRODUCER);
    backingMap.put("meter", Category.CATEGORY_METER);
    backingMap.put("producer", Category.CATEGORY_CONSUMER);
    CATEGORIES_BY_STRING = Collections.unmodifiableMap(backingMap);
}