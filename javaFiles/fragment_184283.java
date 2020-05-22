public class PropertyMatchPredicate<T, P> implements Predicate<T> {
    private final P matchValue;
    private final PropertyExtractor<T, P> extractor;

    public PropertyMatchPredicate(P matchValue, PropertyExtractor<T, P> extractor) {
        this.matchValue = matchValue;
        this.extractor = extractor;
    }

    @Override
    public boolean apply(T obj) {
        return matchValue.equals(extractor.getProperty(obj));
    }
}