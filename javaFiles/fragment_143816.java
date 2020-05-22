import java.util.function.Supplier;

enum FilterFactory {

    INSTANCE;

    private final Map<FilterType, Supplier<FilterDTO>> creators;

    private FilterFactory() {
        creators = new EnumMap<>(FilterType.class); // a bit more efficient :)
        creators.put(FilterType.DATE, DynamicDTO::new);
        creators.put(FilterType.DROP_DOWN_LIST, SimpleDTO::new);
        creators.put(FilterType.FIELD, SimpleDTO::new);
    }

    // other stuff ... 
}