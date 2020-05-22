static <T extends Comparable<T>> List<T> intersect(List<T> list1, List<T> list2) {
    final int size1 = list1.size();
    final int size2 = list2.size();
    final List<T> result = new ArrayList<>(Math.min(size1, size2));

    int i = 0;
    int j = 0;
    while (i < size1 && j < size2) {
        T a = list1.get(i);
        int compare = a.compareTo(list2.get(j));
        if (compare < 0)
            i++;
        else if (compare > 0)
            j++;
        else {
            result.add(a);
            i++;
            j++;
        }
    }

    return result;
}