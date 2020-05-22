ListMultimap<String, MyProduct> result = Multimaps.index(productList, new Function<String, Product>() {
    @Override
    public String apply(Product input) {
        return input.getTitle();
    }
});