private int comparisons = 0;

private int compare(Comparable<?> obj1, Comparable<?> obj2) {
    comparisons++;
    return obj1.compareTo(obj2);
}