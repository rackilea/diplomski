public <T extends List<String>> T sum(
        List<Integer> sublistOfInts,
        List<Boolean> sublistOfBooleans,
        Supplier<T> listMaker) {
    T sublistOfStrings = listMaker.get();
    /*fusion of both lists*/ 

    return sublistOfStrings;
}