Arrays.sort(myArray, new IntStringComparator());

//...

public static class IntStringComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == null) {
            return -1; // o1 is null, should be less than any value 
        }
        if(o2 == null){
            return 1; // o2 is null, should be less than any non-null value
        }
        if (o1 instanceof Integer) {
            if (o2 instanceof Integer) {
                return Integer.compare((int) o1, (int) o2); // Compare by int
            } else {
                return -1; // int < String
            }
        } else {
            if (o2 instanceof String) {
                return ((String) o1).compareTo((String) o2); // Compare by string
            } else {
                return 1; // String > int
            }
        }
    }
}