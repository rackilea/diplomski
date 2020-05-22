public static <T> void merge(ArrayList<ArrayList<T>> arrayLists) {
    int blockSize = 6;
    for(int i=blockSize; i<arrayLists.size(); i++) {
        arrayLists.get(i % blockSize).addAll(arrayLists.get(i));
    }
    arrayLists.subList(blockSize, arrayLists.size()).clear();
}