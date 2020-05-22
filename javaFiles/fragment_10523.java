public final class Type<T extends Comparable<T>> {
    Class<T> type;
    Type(Class<T> _type){
        type = _type;
    }

    public <E extends Comparable<E>> int compare(E val1, E val2) {
        T v1 = type.cast(val1);
        T v2 = type.cast(val2);

        int compTemp = v1.compareTo(v2);
        compTemp++;
        // do stuff
        return compTemp;
    }
}