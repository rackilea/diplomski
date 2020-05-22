public int compareTo(final Circle other) {
    if(other == null) {
        return 1;
    } else {
        return radius - other.getRadius();
    }
}