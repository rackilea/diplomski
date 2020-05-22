class MyClass implements Comparator<Object> {

    public int compare(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        if (o1 instanceof Integer && o2 instanceof String) {
            return 1;
        }
        if (o1 instanceof String && o2 instanceof Integer) {
            return -1;
        }
        if (o1 instanceof Integer && o2 instanceof Integer) {
            return ((Integer) o1).compareTo((Integer) o2);
        }
        return o1.toString().compareTo(o2.toString());
    }
}