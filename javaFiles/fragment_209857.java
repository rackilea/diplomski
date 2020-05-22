public String retrieve(int element) {
    // stuff
    synchronized (scores) { // prevent scores from being modified while iterating
        for (Integer e : scores) {
            // looping stuff
        }
    }
    // more stuff
    return something;
}