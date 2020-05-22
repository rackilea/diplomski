public long getPaws() {
    if (pawsLong > 0) {
        return pawsLong;
    } else {
        // paws used to be an integer
        return paws;
    }
}