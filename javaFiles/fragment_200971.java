public interface Validator<T> {
    Class<T> type();
}
public static class CollectionValidator<Item> implements Validator<Collection<Item>>{
    @SuppressWarnings("unchecked") 
    public Class<Collection<Item>> type() {
        return (Class<Collection<Item>>) (Class<?>) Collection.class;
    }
}