List<List<T>> splitList(List<T> alist, int wantedParts) {
    ArrayList<List<T>> result = new ArrayList<List<T>>();
    int length = alist.length;

    for (int i = 0; i < wantedParts; i++) {
        result.append(alist.subList(i*length/wantedParts,
                                    (i+1)*length/wantedParts));
    }

    return result;
}