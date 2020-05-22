Multimap<String,String> map = Multimaps.newListMultimap(
        new LinkedHashMap<String, Collection<String>>(),
        (Supplier<? extends List<String>>) new Supplier<List<String>>() {
    public List<String> get() {
        return new ArrayList<String>();
    }
});