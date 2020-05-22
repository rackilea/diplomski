class WorkPosition {
    @Override
    public boolean equals(Object obj) {
        // The implementation has to check that obj is WorkPosition,
        // and then compare the content of its attributes and arrays
        // to the corresponding elements of this object
        ...
    }
    @Override
    public int hashCode() {
        // The implementation needs to produce an int based on
        // the values set in object's fields and arrays.
        // The actual number does not matter too much, as long as
        // the same number is produced for objects that are equal.
        ...
    }
}