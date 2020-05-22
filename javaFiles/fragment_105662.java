class Before {
    boolean first;
    boolean second;

    boolean setFirst(boolean newValue) {
        first = newValue;
        second = !first;
    } 

    boolean setSecond(boolean newValue) {
        second = newValue;
        first = !second;
    }
}