static final Comparator<?> NLNO = Comparator.nullsLast(Comparator.naturalOrder());

@SuppressWarnings("unchecked")
static <T extends Comparable<T>> Comparator<T> nlno() {
    return (Comparator<T>)NLNO;
}