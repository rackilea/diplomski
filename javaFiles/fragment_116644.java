public int compareTo(DVD that) {
    if (age > that.getAge()) {
        // this is older than that
        return 1;
    } else if (age < that.getAge()) {
        // this is newer than that
        return -1;
    }

    // this is the same age as that
    return 0;
}