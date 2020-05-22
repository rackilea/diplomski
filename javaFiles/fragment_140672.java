public static void mergeSort(List list) {
if (list == null) throw new NullPointerException("list");
    List temp = recursiveMergeSort(list);
    list.clear();
    list.addAll(temp);
}