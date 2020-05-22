interface DataFetcher {}
class DataFetcher1 implements DataFetcher{}
class DataFetcher2 implements DataFetcher{}

class DataFetcherAccessor<A extends DataFetcher> {
    private static A accessor;

    public static void setImpl(Class<A> c) {
        accessor = c.newInstance();
    }

    public static A getAccessor() [
        return accessor;
    }
}