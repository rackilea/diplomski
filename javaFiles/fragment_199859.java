Comparator<Object> comparator = (a, b) -> {
    if(a instanceof Integer) {
        if(b instanceof Integer) {
            return ((Integer) a).compareTo((Integer) b);
        }
        return -1;
    }
    if(b instanceof Integer)
        return 1;
    return 0;
};