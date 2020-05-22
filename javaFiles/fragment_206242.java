final class ReadJsonStreamIntoListChunksTest
        extends AbstractJsonStreamTest {

    private static final ITest instance = new ReadJsonStreamIntoListChunksTest();

    private ReadJsonStreamIntoListChunksTest() {
    }

    static ITest get() {
        return instance;
    }

    @Nonnull
    @Override
    public List<City> test(@Nonnull final JsonReader jsonReader)
            throws IOException {
        final Collection<List<City>> cityChunks = new ArrayList<>();
        final AtomicReference<List<City>> cityChunkRef = new AtomicReference<>(new ArrayList<>());
        read(jsonReader, city -> {
            final List<City> cityChunk = cityChunkRef.get();
            cityChunk.add(city);
            if ( cityChunk.size() >= 10000 ) {
                cityChunks.add(cityChunk);
                cityChunkRef.set(new ArrayList<>());
            }
        });
        if ( !cityChunkRef.get().isEmpty() ) {
            cityChunks.add(cityChunkRef.get());
        }
        for ( final List<City> cities : cityChunks ) {
            Collections.sort(cities, City::compareByName);
        }
        return merge(cityChunks, City::compareByName);
    }

    /**
     * <p>Adapted from:</p>
     * <ul>
     * <li>Original question: https://stackoverflow.com/questions/1774256/java-code-review-merge-sorted-lists-into-a-single-sorted-list</li>
     * <li>Accepted answer: https://stackoverflow.com/questions/1774256/java-code-review-merge-sorted-lists-into-a-single-sorted-list/1775748#1775748</li>
     * </ul>
     */
    @SuppressWarnings("MethodCallInLoopCondition")
    private static <E> List<E> merge(final Iterable<? extends List<E>> lists, final Comparator<? super E> comparator) {
        int totalSize = 0;
        for ( final List<E> l : lists ) {
            totalSize += l.size();
        }
        final List<E> result = new ArrayList<>(totalSize);
        while ( result.size() < totalSize ) { // while we still have something to add
            List<E> lowest = null;
            for ( final List<E> l : lists ) {
                if ( !l.isEmpty() ) {
                    if ( lowest == null || comparator.compare(l.get(0), lowest.get(0)) <= 0 ) {
                        lowest = l;
                    }
                }
            }
            assert lowest != null;
            result.add(lowest.get(0));
            lowest.remove(0);
        }
        return result;
    }

}