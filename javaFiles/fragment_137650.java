// using the core as the count;
// since your task is CPU-bound, we can directly use parallelStream;
private static void testThreadPool(List<Integer> listDir) {
    // if one of the tasks failed, you got isFailed == true;
    boolean isFailed = splitList(listDir, Runtime.getRuntime().availableProcessors()).stream()
            .parallel().map(YourClass::parallelDeleteOperation).anyMatch(ret -> ret == false); // if any is false, it gives you false
}


// split up the list into "count" lists;
private static <T> List<List<T>> splitList(List<T> list, int count) {
    List<List<T>> listList = new ArrayList<>();
    for (int i = 0, blockSize = list.size() / count; i < count; ++i) {
        listList.add(list.subList(i * blockSize, Math.min((i+1) * blockSize, list.size()));
    }
    return listList;
}