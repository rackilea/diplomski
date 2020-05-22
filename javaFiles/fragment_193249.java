public class BetterMemoizeCountryList implements ICountryList {

    LazyCache<List<String>> cache = new LazyCache<List<String>>(new Supplier<List<String>>(){
        @Override
        public List<String> get() {
            return loadCountryList();
        }
    });

    @Override
    public List<String> list(){
        return cache.get();
    }

    @Override
    public void invalidateCache(){
        cache.invalidate();
    }

    private List<String> loadCountryList() {
        // this should normally load a full list from the database,
        // but just for this instance we mock it with:
        return Arrays.asList("Germany", "Russia", "China");
    }
}