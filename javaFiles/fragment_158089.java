static <T> List<List<T>> split(List<T> list, int n) {

    List<List<T>> parts = new ArrayList<List<T>>();
    int size = list.size();

    for (int index = 0; index < size; index += n) {
        parts.add(new ArrayList<T>(
            list.subList(index, Math.min(size, index + n)))
        );
    }
    return parts;
}